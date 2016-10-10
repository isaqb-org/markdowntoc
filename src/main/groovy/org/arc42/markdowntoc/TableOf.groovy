package org.arc42.markdowntoc
// represents a table-of-<something>, where <something>
// is (as of today) either

class TableOf<T extends AnchoredMarkdownHeading> implements Iterable {

    final static String TWO_COLUMN_ROW_SEPARATOR = "|-------|-------------------|\n"

    private List<T> tableOfSomething = new ArrayList<T>()

    // either TIPS or QUESTIONS
    private String typeName


    String toString() {

        return tableOfSomething.join("\n")

    }



    List<T> getAllHeadings() {
        return tableOfSomething
    }

    void addEntry( AnchoredMarkdownHeading amh) {
        tableOfSomething.add( amh )
    }

    int size() {
        return tableOfSomething.size()
    }


    void append( TableOf<T> newTable ) {
        tableOfSomething += newTable
    }



    final String toTwoColumnMarkdownTable() {

        // TODO: replace with inject(), could be more "functional"
        // http://blog.octo.com/en/groovy-minute-inject/
        // http://mrhaki.blogspot.com.cy/2009/09/groovy-goodness-using-inject-method.html
        // https://kousenit.org/2014/10/14/spaceships-elvis-and-groovy-inject/
        def result = ""
        tableOfSomething.each { entry ->
            result += entry.toMarkdownTwoColumnTableRow() + TWO_COLUMN_ROW_SEPARATOR
        }
        return result
    }

    @Override
    public Iterator<T> iterator() {
        return tableOfSomething.iterator();
    }


    final String createTwoColumnTableHeading() {
       return "\n|ID/Link |$typeName    |\n" + TWO_COLUMN_ROW_SEPARATOR

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

