interface ImmutableFiles {
    fun getFiles(): List<ImmutableFile>
}

interface MutableFiles : ImmutableFiles {
    fun addFile(file: MutableFile): Boolean
    fun remove(file: MutableFile): Boolean
}

class Files : MutableFiles {
    private val files: MutableList<MutableFile> = mutableListOf()
    override fun getFiles(): List<ImmutableFile> = files
    override fun addFile(file: MutableFile): Boolean =
        files
            .add(file)
            .also { println("${file.name} 파일을 추가했습니다.") }
    override fun remove(file: MutableFile): Boolean =
        files
            .remove(file)
            .also { println("${file.name} 파일을 삭제했습니다.") }
}