object ChocolateBoiler {
    // @Volatile
    private var empty: Boolean = true
    private var boiled: Boolean = false

    fun fill() {
        println("재료가 채워집니다.")
        if (isEmpty()) {
            empty = false
            boiled = false
        }
    }

    fun drain() {
        println("물을 끓입니다.")
        if (!isEmpty() && isBoiled()) {
            empty = true
        }
    }

    fun isEmpty(): Boolean {
        // println("초콜릿이 채워져있는가? " + if (empty) "네" else "아니오")
        return empty
    }

    fun isBoiled(): Boolean {
        // println("물이 끓고 있는가? " + if (boiled) "네" else "아니오")
        return boiled
    }
}