package org.arc42.markdowntoc

import spock.lang.Specification

class AnchoredMarkdownHeadingSpec extends Specification {

    final String gTITLE = "Eat healthy!"
    final String gID    = "Tip V-1"
    final String ts     =  "#### $gID: $gTITLE"
    Tip tip


    def setup() {
        tip = new Tip( ts )

    }

    def "can split Tip, ID and net content"() {

        expect:
            tip.pureTitle == gTITLE
            tip.typeAndID == gID
    }



    def "can create Markdown content line"() {
        given:
        final String an = "#tip-v-1"

        when:
        tip.setAnchor("{$an}")
        String contentLine = tip.toMarkdownTwoColumnTableRow()

        then:
        contentLine == "|[${tip.typeAndID}]($an) |${tip.pureTitle} |\n"

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

