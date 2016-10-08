package org.arc42.markdowntoc

class Tip extends AnchoredMarkdownHeading {

    static final String HEADING_TYPE_NAME = "Tip"

    static final String TIPS_MATCHER = /^#### Tip\s*/
    static final String PURE_TIP_MATCHER = /^Tip\s*/

    static final String WRONG_TIPS_MATCHER = /^#{1,3} Tip/


    Tip( String completeLine ) {
        super( completeLine )
    }


    // checks if format of heading is correct
    final void assertCorrectFormat() {
        assert pureHeadingText =~ PURE_TIP_MATCHER
    }


    static boolean matches(String line) {
        return (line =~ TIPS_MATCHER)
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

