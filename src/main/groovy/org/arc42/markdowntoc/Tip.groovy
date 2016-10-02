package org.arc42.markdowntoc

class Tip  {
    static final String TIPS_MATCHER = /^#### Tip\s*/
    static final String WRONG_TIPS_MATCHER = /^#{1,3} org.arc42.markdowntoc.Tip/

    String  title


    String toString() {
        return "org.arc42.markdowntoc.Tip " + title
    }

    /**
     * checks if @param line complies to our "org.arc42.markdowntoc.Tip" convention
     * (4 leading '#' etc.)
     * @param line: check if this is a "org.arc42.markdowntoc.Tip"
     */
    static Boolean isTip( String line) {
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

