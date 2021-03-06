package org.arc42.markdowntoc

class Anchor {

    static final String ANCHOR_MATCHER = /^\{#(.)*\}/

    static final String PURE_ANCHOR_MATCHER = /^#(.)*/


    //
    private String pureAnchor

    Anchor( String completeAnchorLine ) {
        this.pureAnchor = completeAnchorLine
                           .substring(completeAnchorLine.indexOf("{") + 1, completeAnchorLine.indexOf("}"))
                           .trim()

        assert this.pureAnchor =~ PURE_ANCHOR_MATCHER
    }


    String getPureAnchor() {
       return pureAnchor
    }

    String toString() {
        return "org.arc42.markdowntoc.Anchor " + pureAnchor
    }

    /**
     * checks if @param line complies to our "org.arc42.markdowntoc.Anchor" convention
     **/
    static Boolean isAnchor( String line) {
        return (line =~ ANCHOR_MATCHER)
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

