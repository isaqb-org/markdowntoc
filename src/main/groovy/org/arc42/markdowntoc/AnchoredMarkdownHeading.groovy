package org.arc42.markdowntoc

abstract class AnchoredMarkdownHeading {

    static final String MD_HEADING_PREFIX = "####"


    // including "#"-symbols and chapter-number
    // e.g.: #### Question J-1: How to document (very) large systems with arc42
    protected String completeHeadingLine

    // e.g.: Question J-1: How to document (very) large systems with arc42
    protected String pureHeadingText

    protected Anchor anchor

    AnchoredMarkdownHeading() {
        this.completeHeadingLine = ""
        this.pureHeadingText     = ""
    }

    AnchoredMarkdownHeading(String completeLine ) {
        this.completeHeadingLine = completeLine
        this.setPureHeading()
    }

    void setPureHeading() {
        pureHeadingText = completeHeadingLine
                .replace( MD_HEADING_PREFIX, "")
                .trim()

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

