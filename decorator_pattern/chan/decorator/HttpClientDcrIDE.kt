package decorator

import IDE
import ImmutableFile
import MutableFiles
import strategy.GrammarCheck

/**
 * 이런 기능은 어떻게 확장 하는게 좋을까
 */
class HttpClientDcrIDE(private val ide: IDE) : IDE {

    override val files: MutableFiles = ide.files
    override val grammarCheckers: List<GrammarCheck> = ide.grammarCheckers

    override fun checkGrammar(): List<ImmutableFile> =
        ide.checkGrammar()

    fun http(request: String) {
        println("< Deco : http client 기능 지원 >")
        println(
            """
                |host:$request
                |<!doctype html>
                |   네이버
                |</html>
            """.trimMargin("|")
        )
    }

}