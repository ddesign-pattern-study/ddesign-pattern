import strategy.GrammarCheck

/**
 * IDE interface
 */
interface IDE : Editor {
    val grammarCheckers: List<GrammarCheck>
    val files: MutableFiles

    override fun editBody(file: Editable, body: String): Boolean =
        super
            .editBody(file = file, body = body)
            .also { checkGrammar() }

    override fun changeExtension(file: Editable, extension: Extension): Boolean =
        super
            .changeExtension(file = file, extension = extension)
            .also { checkGrammar() }

    override fun changeName(file: Editable, name: String): Boolean =
        super
            .changeName(file = file, name = name)
            .also { checkGrammar() }

    override fun addFile(file: MutableFile): Boolean =
        files
            .addFile(file)
            .also { checkGrammar() }

    override fun remove(file: MutableFile): Boolean =
        files
            .remove(file)
            .also { checkGrammar() }

    fun checkGrammar(): List<ImmutableFile> =
        grammarCheckers
            .flatMap { it.checkGrammarFiles(files) }
            .also { resultList ->
                if(resultList.isNotEmpty()) {
                    println("< 문법 오류 >")
                    resultList.forEach {
                        println(
                            """
                                |---------------------------------------------
                                |Filename : ${it.name}.${it.extension.extension}
                                |Body :
                                |${it.body}
                                |---------------------------------------------
                            """.trimMargin("|")
                        )
                    }
                }
                else
                    println("---컴파일 오류 없음---")
            }
}