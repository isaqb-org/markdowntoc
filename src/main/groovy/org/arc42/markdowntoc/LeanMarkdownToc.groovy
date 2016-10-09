package org.arc42.markdowntoc
/*
 * @author gstarke, @date October 2016
 */
import static groovy.io.FileType.FILES

class LeanMarkdownToc {

    static final String USERNAME = System.getenv("USER")
    static final String BOOK_DIR = "/Users/${USERNAME}/projects/arc42-in-practice"

    static final String MANUSCRIPT_DIR = "${BOOK_DIR}/manuscript"

    static final String TABLE_OF_DIR = "${MANUSCRIPT_DIR}/99_generated"
    static final String TO_TIPS_FILENAME = "generated-table-of-tips.md"
    static final String TO_QUESTIONS_FILENAME = "generated-table-of-questions.md"

    static final String MARKDOWN_EXTENSION = ".md"


    static TableOf<Question> toQuestions = new TableOf<Question>(typeName: "Questions")
    static TableOf<Tip>      toTips = new TableOf<Tip>(typeName: "Tips")

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

    static BufferedWriter createFileToWrite( String filename) {
        def genDir = new File(TABLE_OF_DIR)
        if (!genDir.exists()) {
            genDir.mkdirs()
        }
        return new File( "$genDir/$filename").newWriter("UTF-8")
    }

    static void writeMarkdownFile( TableOf<AnchoredMarkdownHeading> tableOf, String filename) {

        createFileToWrite(filename) << tableOf.toTwoColumnMarkdownTable()

        println "wrote $TABLE_OF_DIR/$filename."
    }

    static void main(String[] args) {
        def dir = new File(MANUSCRIPT_DIR)
        assertFilesExist( dir )

        traverseAllMarkdownFiles(dir)

        writeMarkdownFile( toQuestions, TO_QUESTIONS_FILENAME)
        println "Found ${toQuestions.size()} questions:"
        println toQuestions.toString()

        writeMarkdownFile( toTips, TO_TIPS_FILENAME)
        println "Found ${toTips.size()} tips:"
        println toTips.toString()


    }
}
