package strategy

import Extension

class PythonGrammar : GrammarCheck {

    override val extension: Extension = Extension("py")

    override val keywords: List<String> = listOf(
        "and", "as", "assert", "async", "await", "break", "class", "continue", "def",
        "del", "elif", "else", "except", "False", "finally", "for", "from", "global",
        "if", "import", "in", "is", "lambda", "None", "nonlocal", "not", "or", "pass",
        "raise", "return", "True", "try", "while", "with", "yield"
        // ":", ",", "[", "]", "(", ")", "."
    )

}