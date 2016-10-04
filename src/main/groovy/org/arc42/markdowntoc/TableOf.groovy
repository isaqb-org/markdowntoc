package org.arc42.markdowntoc
// represents a table-of-<something>, where <something>
// is (as of today) either

class TableOf<T extends AnchoredMarkdownHeading> implements Iterable {

    private List<T> tableOfSomething = new ArrayList<T>()

    // generic constructur without type parameter
    //TableOf() {
    //    this.tableOfSomething = new ArrayList<T>()
    //}

    List<T> getAllHeadings() {
        return tableOfSomething
    }

    void addEntry( AnchoredMarkdownHeading amh) {
        tableOfSomething.add( amh )
    }

    int size() {
        return tableOfSomething.size()
    }

    @Override
    public Iterator<T> iterator() {
        return tableOfSomething.iterator();
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

