package org.arc42.markdowntoc

class Question extends AnchoredMarkdownHeading {


    static final String HEADING_TYPE_NAME = "Question"


    static final String QUESTION_MATCHER = /^####\sQuestion\s*/
    static final String PURE_QUESTION_MATCHER = /^Question\s*/

    static final String BAD_QUESTION_MATCHER = /^#{1,3} Question/


    Question( String line) {
        super(line)
    }

    // checks if format of heading is correct
    void assertCorrectFormat() {
        assert pureHeadingText =~ PURE_QUESTION_MATCHER
    }


    static boolean isQuestion(String line) {
        return (line =~ QUESTION_MATCHER)
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

