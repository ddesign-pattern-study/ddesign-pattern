import decorator.ColorfulDcrIDE
import decorator.HttpClientDcrIDE
import decorator.JvmIDE
import decorator.KotlinIDE
import decorator.OrmSupportDcrIDE
import decorator.PythonIDE
import decorator.SpellCheckDcrIDE

fun main( ) {

    println("1. community 코틀린 IDE 실행")
    val communityKotlinIDE = KotlinIDE()

    println("2. ultimate 코틀린 IDE 실행")
    val ultimateKotlinIDE =
        HttpClientDcrIDE(
            OrmSupportDcrIDE(
                ColorfulDcrIDE(
                    SpellCheckDcrIDE(
                        KotlinIDE()
                    )
                )
            )
        )

    println("3. community 코틀린 IDE 파일 추가")
    communityKotlinIDE.addFile(
        file = BasicFile(
            name = "HelloKotlin",
            extension = Extension("kt"),
            body = """
                
                fun main() {
                    val banana = "banana"
                    println(banana)
                }
                
            """.trimIndent(),
            path = "/kotlin/community"
        )
    )

    val ultimateKotlinFile = BasicFile(
        name = "HelloKotlin",
        extension = Extension("kt"),
        body = """
                
                fun main() {
                    val banana = "바나나"
                    println(banana)
                }
                
            """.trimIndent(),
        path = "/kotlin/ultimate"
    )

    println("4. ultimate 코틀린 IDE 파일 추가")
    ultimateKotlinIDE.addFile(file = ultimateKotlinFile)

    println("5. ultimate 코틀린 IDE 파일 수정")
    ultimateKotlinIDE.editBody(
        file = ultimateKotlinFile,
        body = """
            
                def helloWorld():
                    banana = "바나나"
                    print(banana)
                }
            
        """.trimIndent()
    )

    println("6. ultimate 코틀린 IDE http client 기능 실행")
    ultimateKotlinIDE.http("https://www.naver.com")

    println("7. community Jvm 실행")
    val communityJvmIDEIDE = JvmIDE()

    println("8. community Jvm IDE 파일 추가")
    communityJvmIDEIDE.addFile(
        file = BasicFile(
            name = "HelloKotlin",
            extension = Extension("kt"),
            body = """
                
                fun main() {
                    val banana = "banana"
                    println(banana)
                }
                
            """.trimIndent(),
            path = "/jvm/community"
        )
    )

}