package strategy

import Extension
import ImmutableFile
import ImmutableFiles

interface GrammarCheck {
    val extension: Extension
    val keywords: List<String>
    fun checkGrammarFiles(files: ImmutableFiles): List<ImmutableFile> =
        files
            .getFiles()
            .filter { it.extension == extension }
            .filter { file ->
                file.body.trimIndent()
                    .split("\\s+".toRegex())
                    .none(keywords::contains)
            }
}