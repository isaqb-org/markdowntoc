package org.arc42.markdowntoc

import spock.lang.Specification
import spock.lang.Unroll

class QuestionSpec extends Specification {

    @Unroll
    def "can recognize questions()"(String someText, Boolean isQuestion) {

        expect:
        Question.isQuestion( someText ) == isQuestion

        where:
        someText                    | isQuestion
        "#### Question A-1: What's _42_?" | true
        "#### Question A-2 What's up?" | true
        "#### Question J-3: Is there a checklist for arc42 documentation?\n" | true


        // bad markdown heading
        "### Question on bad heading level" | false
        "## Question on bad heading level" | false
        "# Question on bad heading level" | false
        "another question was, if"  | false
        "# Section I: Questions"    | false
        "## Questions on Groovy"    | false
        "Question B-2: What's 13?"  | false
    }

    def "bad question throws AssertionError"() {
        when:
        Question question = new Question("### Question: Bad Heading Level")

        then:
        thrown AssertionError
    }
}

/************************************************************************
 * This is free software - without ANY guarantee!
 *
 *
 * Copyright Dr. Gernot Starke, arc42.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *********************************************************************** */

