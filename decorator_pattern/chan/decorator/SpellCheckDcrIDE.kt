package decorator

import IDE
import ImmutableFile
import MutableFiles
import strategy.GrammarCheck

class SpellCheckDcrIDE(private val ide: IDE) : IDE {

    override val files: MutableFiles = ide.files
    override val grammarCheckers: List<GrammarCheck> = ide.grammarCheckers

    private val words: List<String> = listOf(
        "apple", "banana", "grape"
    )

    override fun checkGrammar(): List<ImmutableFile> =
        ide
            .checkGrammar()
            .also { checkSpell() }

    private fun checkSpell() {

        println("\t< Deco : Spell 검사 >")

        val fileWords: List<Pair<ImmutableFile, List<String>>> =
            grammarCheckers
                .flatMap { checker ->
                    files
                        .getFiles()
                        .filter { it.extension == checker.extension }
                        .map { file ->
                            file to file.body
                                .trimIndent()
                                .split("\\s+".toRegex())
                                .filterNot(checker.keywords::contains)
                        }
                }

        // 문자 필터링 해서 포함 되지 않을 경우만 추가 해서 리턴
        fileWords
            .mapNotNull { fileWord ->
                val mismatches: List<String> =
                    fileWord
                        .second
                        .filterNot { words.contains(it) }
                if(mismatches.isNotEmpty())
                    SpellCheckResult(
                        wrongWords = mismatches,
                        file = fileWord.first
                    )
                else
                    null
            }
            .also {
                if(it.isNotEmpty())
                    it.forEach(::println)
                else
                    println("spell 체크 통과")
            }
    }

    data class SpellCheckResult(
        val wrongWords: List<String>,
        val file: ImmutableFile
    ) {
        override fun toString(): String {
            return """
                |   SpellCheckResult(
                |       wrongWords = ${wrongWords.joinToString(", ") { it }}, 
                |       body = ${file.body}
                |   )
                """.trimMargin("|")

        }
    }

}