package strategy

import Extension

class JavaGrammar : GrammarCheck {

    override val extension: Extension = Extension("java")

    override val keywords: List<String> = listOf(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
        "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
        "final", "finally", "float", "for", "goto", "if", "implements", "import",
        "instanceof", "int", "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", "super", "switch", "synchronized",
        "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
        // "+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&", "|",
        // "^", "~", "<<", ">>", ">>>", "&&", "||", "!", "=", "+=", "-=", "*=", "/=", "%=",
        // "<<=", ">>=", "&=", "^=", "!=", "?", ":"
    )

}