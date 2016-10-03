package org.arc42.markdowntoc

// walks through markdown (either file or string),
// watching for Tips or Questions with corresponding anchor.
//
// Example:
// {#tip-v-1}
// #### Tip V-1: What a tip...
//

class MarkdownProcessor {

    private ArrayList<String> lines


    MarkdownProcessor(File pFile ) {
        lines = pFile.readLines()
    }

    MarkdownProcessor(String text) {
       lines = text.readLines()
    }

    void traverseMarkdown() {
        println lines
    }

    int getNrOfLines() {
        return lines.size()
    }
    /**
     * searches the given markdown for "Questions" which have an anchor.
     * When question is found without appropriate anchor, exception is thrown...
     * @return
     */
    TableOf<Question> findAnchoredQuestions()  {
        String previousLine = ""

        TableOf<Question> toQ = new TableOf<Question>()
        AnchoredMarkdownHeading question

        lines.each { currentLine ->
            assert currentLine.class == java.lang.String
            def isq = Question.isQuestion(currentLine)
            if (Question.isQuestion( currentLine)) {
                // we found a question
                question = new Question(currentLine)

                if (Anchor.isAnchor(previousLine)) {
                    question.setAnchor(previousLine)
                    toQ.addEntry(question)
                } else {
                    assert false: "$currentLine has no anchor - aborted."
                }
            }

            previousLine = currentLine

        }

        return toQ
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

