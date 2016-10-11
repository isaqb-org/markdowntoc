package org.arc42.markdowntoc

import spock.lang.Specification

class TableOfSpec extends Specification {

    TableOf<Question> toQ


    def setup() {
        toQ = new TableOf<Question>()

    }

    def "can append tableOfQuestions to empty tableOf"() {
        given:
        Question q = new Question("#### Question 1: Why?")
        TableOf<Question> newToQ = new TableOf<Question>()
        newToQ.addEntry(q)


        when:
        toQ.append(newToQ)

        then:
        toQ.size() == 1
    }

    def "can append toQ to existing table"() {
       given:
       Question q = new Question("#### Question 1: Why?")

       toQ.addEntry(q)

       TableOf<Question> newToQ = new TableOf<Question>()
       newToQ.addEntry(q)

        when:
        toQ.append( newToQ )

        then:
        toQ.size() == 2
    }

    def "creates nice table heading"() {
        when:
            def toT = new TableOf<Tip>( typeName: "Tip")
            def heading = toT.createTwoColumnTableHeading()
        then:
            heading.startsWith("""{width="90%"}""")
            heading.contains("|Tip")
            heading.contains("|ID/Link")
            heading.contains(TableOf.TWO_COLUMN_ROW_SEPARATOR)

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

