package decorator

import IDE
import ImmutableFile
import MutableFile
import MutableFiles
import strategy.GrammarCheck

class OrmSupportDcrIDE(private val ide: IDE) : IDE {

    override val files: MutableFiles = ide.files
    override val grammarCheckers: List<GrammarCheck> = ide.grammarCheckers

    override fun checkGrammar(): List<ImmutableFile> =
        ide
            .checkGrammar()
            .also { supportOrm() }

    private fun supportOrm() {
        println("\t< Deco : orm 문법 검사 >")
    }

}