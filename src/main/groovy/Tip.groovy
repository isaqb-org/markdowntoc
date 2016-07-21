class Tip {
    static final String TIPS_MATCHER = /^#### Tip*/
    static final String WRONG_TIPS_MATCHER = /^#{1,3} Tip/


    String  fileName // the markdown filename where this tip is defined
    String  chapter
    int     number
    String  title


    String toString() {
        return "Tip " + chapterAndNumber().toUpperCase()
            + title
    }

    String chapterAndNumber() {
        return chapter + "-" + number
    }

    String toMarkdownLink() {
        String chapNr = chapterAndNumber()

        return """[Tip ${chapNr.toUpperCase()}](#tip-${chapNr.toLowerCase()})"""
    }

    /**
     * checks if @param line complies to our "Tip" convention
     * (4 leading '#' etc.)
     * @param line: check if this is a "Tip"
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

