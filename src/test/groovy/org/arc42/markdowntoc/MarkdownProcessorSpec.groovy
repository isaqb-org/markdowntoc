package org.arc42.markdowntoc


import spock.lang.Specification

class MarkdownProcessorSpec extends Specification {

    MarkdownProcessor mdp

    static String qanchor1 = "#q-J-1"
    static String question1 = "Question J-1: How to document (very) large systems with arc42?"

    static String tanchor1 = "#tip-iv-29"
    static String tip1 = "Tip IV-29: Explicitely demarcate your system"
    static String longMarkdown = """

{$tanchor1}
#### $tip1

![](images/icon-important-30px.png)

You should demarcate your system from the ...

{$qanchor1}
#### $question1

<t.b.d.>


{#q-J-2}
#### Question J-2: Does a governance_ make sense for architecture documentation?

lore ipsum lore ipsum

{#q-J-3}
#### Question J-3: Is there a checklist for arc42 documentation?

<t.b.d.>

{#tip-v-1}
#### Tip V-1: Eat healthy!

Low carb seems better than ##high volume##.

{bad-anchor}
Question: this is no question?

"""

    def setup() {
        mdp = new MarkdownProcessor(longMarkdown)
    }

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


    def "can find questions in longer markdown"() {
        when:
            TableOf<Question> toQ = mdp.findAnchoredQuestions()

        then:
            toQ.size() == 3
            toQ.getAllHeadings().get(0).pureHeadingText == question1
            toQ.getAllHeadings().get(0).anchor.pureAnchor == qanchor1

            //
            toQ.each { question ->
                assert question.pureHeadingText != ""
                assert question.anchor != ""

            }
    }


    def "can find tips in longer markdown"() {
        when:
        TableOf<Tip> toT = mdp.findAnchoredTips()

        then:
        toT.size() == 2
        toT.getAllHeadings().get(0).pureHeadingText == tip1
        toT.getAllHeadings().get(0).anchor.pureAnchor == tanchor1

        //
        toT.each { tip->
            assert tip.pureHeadingText != ""
            assert tip.anchor != ""

        }
    }
}