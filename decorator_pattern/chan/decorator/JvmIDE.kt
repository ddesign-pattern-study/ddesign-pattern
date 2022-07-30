package decorator

import BasicIDE
import strategy.GrammarCheck
import strategy.JavaGrammar
import strategy.KotlinGrammar

class JvmIDE : BasicIDE() {

    override val grammarCheckers: List<GrammarCheck> = listOf(KotlinGrammar(), JavaGrammar())

}