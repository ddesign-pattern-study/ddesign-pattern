import strategy.GrammarCheck

abstract class BasicIDE : IDE {
    override val files: MutableFiles = Files()
    override val grammarCheckers: List<GrammarCheck> = listOf()
}