package org.arc42.markdowntoc
/*
 * This Groovy source file was auto generated by running 'gradle buildInit --type groovy-library'
 * by 'gstarke' at '22.02.16 21:54' with Gradle 2.11
 *
 * @author gstarke, @date 22.02.16 21:54
 */
import static groovy.io.FileType.FILES

class LeanMarkdownToc {

    static final String USERNAME = System.getenv("USER")
    static final String BOOK_DIR = "/Users/${USERNAME}/projects/arc42-in-practice"

    static final String MANUSCRIPT_DIR = "${BOOK_DIR}/manuscript"

    static final String TABLE_OF_DIR = "${MANUSCRIPT_DIR}/99_generated_tables"

    static final String TO_TIPS_FILENAME =
            "$TABLE_OF_DIR/generated-table-of-tips.md"


    static final String QUESTION_FORMAT = /#### Question*/

    static final String TO_QUESTIONS_FILENAME =
            "$TABLE_OF_DIR/generated-table-of-questions.md"

    static final String MARKDOWN_EXTENSION = ".md"

    static int nrOfTips = 0
    static int nrOfQuestions = 0

    static ArrayList<Tip> tips
    static ArrayList<String> questions

    static TableOf<Question> toQuestions = new TableOf<Question>()
    static TableOf<Tip>      toTips = new TableOf<Tip>()

    static assertFilesExist( File dir ) {
        assert dir.exists(), "\n\nDirectory $dir does not exist\n"
    }


    static void traverseAllMarkdownFiles(File contentDir) {
        contentDir.eachFileRecurse(FILES) { currentFile ->
            if (currentFile.name.endsWith('.md')) {
                traverseSingleFile(currentFile)
            }
        }
    }

    static void traverseSingleFile(File currentFile) {
        println "processing $currentFile"
        MarkdownProcessor mdp = new MarkdownProcessor( currentFile )
        toQuestions.append( mdp.findAnchoredQuestions() )
        toTips.append( mdp.findAnchoredTips())
    }


    // old version - includes filename for better error handling
    static void processLine( String currentLine, File currentFile) {
        //checkTip( currentLine, currentFile )
        //checkQuestion( currentLine, currentFile)
    }



    static void main(String[] args) {
        def dir = new File(MANUSCRIPT_DIR)

        tips = new ArrayList<String>()

        assertFilesExist( dir )

        traverseAllMarkdownFiles(dir)

        println "Found ${toQuestions.size()} questions:"
        println toQuestions.toString()

        println "Found ${toTips.size()} tips:"
        println toTips.toString()
    }
}
