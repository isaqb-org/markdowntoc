package org.arc42.markdowntoc

abstract class AnchoredMarkdownHeading {

    static final String MD_HEADING_PREFIX = "####"


    // e.g.: Question J-1: How to document (very) large systems with arc42
    protected String pureHeadingText

    protected Anchor anchor

    protected String typeAndID // e.g. "Tip IV-107"
    protected String pureTitle     // a.g. "Create at least a domain-model"


    AnchoredMarkdownHeading() {
        this.pureHeadingText     = ""
    }

    AnchoredMarkdownHeading(String completeLine ) {

        this.extractPureHeadingAndID( completeLine)
    }

    String toString() {
        return pureHeadingText
    }

    String toMarkdownTwoColumnTableRow() {
        return "|[$typeAndID](${anchor.pureAnchor}) |$pureTitle |\n"
    }

    abstract void assertCorrectFormat()

    static void complainIfIncorrectPrefix( String completeLine ) {
        if (!completeLine.startsWith( MD_HEADING_PREFIX )) {
            println "v"*50
            println "Error: $completeLine does not start with $MD_HEADING_PREFIX"
            println "^"*50
        }

    }


    void extractPureHeadingAndID( completeLine ) {

        complainIfIncorrectPrefix( completeLine )

        pureHeadingText = completeLine
                .replace( MD_HEADING_PREFIX, "")
                .trim()

        assertCorrectFormat()

        setTypeIDAndTitle( this.pureHeadingText )
    }

    private void setTypeIDAndTitle( String pureHeading) {
        def both = pureHeading.split(/: /)

        assert both.length == 2

        typeAndID = both[0].trim()
        pureTitle = both[1].trim()


    }

    void setAnchor( Anchor anc ) {
        this.anchor = anc
    }

    void setAnchor( String anchorString ) {
        this.anchor = new Anchor( anchorString )
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

