package decorator

import IDE
import ImmutableFile
import MutableFiles
import strategy.GrammarCheck

class ColorfulDcrIDE(private val ide: IDE) : IDE {

    override val files: MutableFiles = ide.files
    override val grammarCheckers: List<GrammarCheck> = ide.grammarCheckers

    override fun checkGrammar(): List<ImmutableFile> =
        ide
            .checkGrammar()
            .also { displayColor() }

    private fun displayColor() {
        println("\t< Deco : 다양한 컬러 지원!!> ")
    }

}