interface Edit {
    fun desc(): String
    fun editBody(file: Editable, body: String): Boolean =
        file.editBody(body).also { println("파일을 수정했습니다.") }
    fun changeExtension(file: Editable, extension: Extension): Boolean =
        file.changeExtension(extension).also { println("파일의 확장자를 변경했습니다.") }
    fun changeName(file: Editable, name: String): Boolean =
        file.changeName(name).also { println("파일 이름을 수정했습니다.") }
}

interface Editor : Edit {
    override fun desc(): String = "Edit by EndUser"
    fun addFile(file: MutableFile): Boolean
    fun remove(file: MutableFile): Boolean
}