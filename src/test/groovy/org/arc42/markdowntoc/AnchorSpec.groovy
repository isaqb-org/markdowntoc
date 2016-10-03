package org.arc42.markdowntoc

import spock.lang.Specification

class AnchorSpec extends Specification {

    def "can recognize simple anchors"( String candidate, Boolean isValidAnchor ) {

        expect:
            Anchor.isAnchor( candidate ) == isValidAnchor

        where:

        candidate     | isValidAnchor
        "{#q-A-1}"    | true
        "{#q-A-2}"    | true
        "{#tipp-I-1}" | true
        "{#section-vii-B}" | true
        "{#fig-arc42-metaphor}" | true
        "{#chapter-iii}" | true
        "{#rule-III-1}" | true

        "{pagebreak}" | false
        "{q-vii-1}"   | false
        "Lore ipsum"  | false
        "## A Header" | false
        "![](images/blurp.png)" | false

    }


    def "can create correct anchor instances"(String line, String pureAnchor) {
        when:
            Anchor anc = new Anchor(line)

        then:
            anc.getPureAnchor() == pureAnchor

        where:
        line | pureAnchor
        "{#q-A-1}"    | "#q-A-1"
        "{#q-A-2}"    | "#q-A-2"
        "{#tipp-I-1}" | "#tipp-I-1"

    }

    def "bad anchor throws AssertionError"() {
        when:
         Anchor anc = new Anchor( "{bad-anchor}")

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

