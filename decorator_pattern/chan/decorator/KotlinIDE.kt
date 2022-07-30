package decorator

import BasicIDE
import strategy.GrammarCheck
import strategy.KotlinGrammar

class KotlinIDE : BasicIDE() {

    override val grammarCheckers: List<GrammarCheck> = listOf(KotlinGrammar())

}