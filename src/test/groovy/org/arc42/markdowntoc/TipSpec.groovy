package org.arc42.markdowntoc

import spock.lang.Specification

class TipSpec extends Specification {

    Tip awesomeTip



    def "can recognize tips"( String tipLine, Boolean isValidTip) {

        expect:
            Tip.isTip( tipLine) == isValidTip

        where:
        tipLine                                 | isValidTip
        "#### Tip I-1 Our numbering"            | true
        "#### Tip III-9: Document Unmistakably" | true

        "#### Question VII-A-1"                 | false
        "Tip 42: Plain Wrong"                   | false
        "# A Heading Tip"                       | false
        "## Another Tip"                        | false
        "just a tip in text"                    | false

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

