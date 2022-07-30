import java.util.UUID

interface Editable {
    fun editBody(body: String): Boolean
    fun changeExtension(extension: Extension): Boolean
    fun changeName(name: String): Boolean
}

interface ImmutableFile {
    val name: String
    val extension: Extension
    val body: String
    val path: String
}

interface MutableFile : ImmutableFile, Editable

data class BasicFile(
    override var name: String,
    override var extension: Extension,
    override var body: String,
    override val path: String
) : MutableFile {
    val uuid: UUID = UUID.randomUUID()
    override fun editBody(body: String): Boolean {
        this.body = body
        return true
    }
    override fun changeExtension(extension: Extension): Boolean {
        this.extension = extension
        return true
    }
    override fun changeName(name: String): Boolean {
        this.name = name
        return true
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BasicFile
        if (uuid != other.uuid) return false
        return true
    }
    override fun hashCode(): Int {
        return uuid.hashCode()
    }

    override fun toString(): String {
        return """
            |   BasicFile(
            |       uuid='$uuid', 
            |       name='$name', 
            |       extension=$extension, 
            |       body='$body', 
            |       path='$path'
            |   )
        """.trimMargin("|")
    }

}

data class Extension(
    val extension: String
)