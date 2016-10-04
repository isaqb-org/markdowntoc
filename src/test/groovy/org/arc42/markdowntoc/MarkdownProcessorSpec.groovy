package org.arc42.markdowntoc


import spock.lang.Specification
import spock.lang.Unroll

class MarkdownProcessorSpec extends Specification {

    MarkdownProcessor mdp



    def "can find question with anchor"() {
        given:
            String pureQuestion = "Question J-1: How to?"
            String pureAnchor   = "#q-J-1"
            String md = """{$pureAnchor} \n#### $pureQuestion\n<t.b.d.>"""
            mdp = new MarkdownProcessor( md )

        when:
            TableOf<Question> toQ = mdp.findAnchoredQuestions()

        then:
            toQ.size() == 1
            toQ.getAllHeadings().get(0).pureHeadingText == pureQuestion
            toQ.getAllHeadings().get(0).anchor.pureAnchor == pureAnchor


    }


}