package strategy

import Extension

class KotlinGrammar : GrammarCheck {

    override val extension: Extension = Extension("kt")

    override val keywords: List<String> = listOf(
        "as", "as?", "break", "class", "continue", "do", "else", "false", "for",
        "fun", "if", "in", "!in", "interface", "is", "!is", "null", "object", "package",
        "return", "super", "this", "throw", "true", "try", "typealias", "typeof", "val",
        "var", "when", "while", "by", "catch", "constructor", "delegate", "dynamic",
        "field", "file", "finally", "get", "import", "init", "param", "property", "receiver",
        "set", "setparam", "value", "where", "abstract", "actual", "annotation", "companion",
        "const", "crossinline", "data", "enum", "expect", "external", "final", "infix",
        "inline", "inner", "internal", "lateinit", "noinline", "open", "operator", "out",
        "override", "private", "protected", "public", "reified", "sealed", "suspend", "tailrec",
        "vararg", "it",
        // "+", "-", "*", "/", "%", "=", "+=", "-=", "*=", "/=", "%=", "++", "--", "&&",
        // "||", "!", "==", "!=", "===", "!==", "<", ">", "<=", ">=", "[", "]", "!!", "?.",
        // "?:", "::", "..", ":", "?", "->", "@", ";", "$", "_"
    )

}