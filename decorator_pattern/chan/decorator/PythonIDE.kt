package decorator

import BasicIDE
import strategy.GrammarCheck
import strategy.PythonGrammar

class PythonIDE : BasicIDE() {

    override val grammarCheckers: List<GrammarCheck> = listOf(PythonGrammar())

}