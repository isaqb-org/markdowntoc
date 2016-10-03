package org.arc42.markdowntoc


import spock.lang.Specification
import spock.lang.Unroll

class MarkdownProcessorSpec extends Specification {

    MarkdownProcessor mdp


    def "can find question with anchor"() {
        given:
            String md = """{#q-J-1} \n#### Question J-1: How to?\n<t.b.d.>"""
            mdp = new MarkdownProcessor( md )

        when:
            TableOf<Question> toQ = mdp.findAnchoredQuestions()

        then:
            toQ.size() == 1


    }


}