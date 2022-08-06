abstract class PizzaStore {
    fun orderPizza(type: String): Pizza {
        return createPizza(type).run {
            prepare()
            bake()
            cut()
            box()
            this@run
        }
    }

    abstract fun createPizza(type: String): Pizza
}

class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> NYStyleCheesePizza()
            "veggie" -> NYStyleVeggiePizza()
            "pepperoni" -> NYStylePepperoniPizza()
            else -> throw RuntimeException("no menu")
        }
    }
}

class ChicagoPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> ChicagoStyleCheesePizza()
            "veggie" -> ChicagoStyleVeggiePizza()
            "pepperoni" -> ChicagoStylePepperoniPizza()
            else -> throw RuntimeException("no menu")
        }
    }
}

abstract class Pizza(
    val name: String,
    private val dough: String,
    private val sauce: String,
    private val toppings: List<String>
) {
    fun prepare() {
        println("준비 중 : $name")
        println("도우를 돌리는 중...")
        println("소스를 뿌리는 중...")
        println("토핑을 올리는 중...")
        toppings.map {
            println(" $it")
        }
    }

    open fun bake() {
        println("175도에서 25분 간 굽기")
    }

    open fun cut() {
        println("피자를 사선으로 자르기")
    }

    open fun box() {
        println("상자에 피자 담기")
    }
}

class NYStyleCheesePizza() : Pizza(
    name = "뉴욕 스타일 소스와 치즈 피자",
    dough = "씬 크러스트 도우",
    sauce = "마리나라 소스",
    toppings = listOf("잘게 썬 레지아노 치즈")
)

class NYStylePepperoniPizza : Pizza(
    name = "뉴욕 스타일 소스와 페퍼로니 피자",
    dough = "씬 크러스트 도우",
    sauce = "마리나라 소스",
    toppings = listOf("잘게 썬 레지아노 치즈")
)

class NYStyleVeggiePizza : Pizza(
    name = "뉴욕 스타일 소스와 야채 피자",
    dough = "씬 크러스트 도우",
    sauce = "마리나라 소스",
    toppings = listOf("잘게 썬 레지아노 치즈")
)

class ChicagoStyleCheesePizza() : Pizza(
    name = "시카고 스타일 딥 디쉬 치즈 피자",
    dough = "아주 두꺼운 크러스트 도우",
    sauce = "플럼토마토 소스",
    toppings = listOf("잘게 조각낸 모짜렐라 치즈")
) {
    override fun cut() {
        println("네모난 모양으로 피자 자르기")
    }
}

class ChicagoStyleVeggiePizza() : Pizza(
    name = "시카고 스타일 야채 피자",
    dough = "아주 두꺼운 크러스트 도우",
    sauce = "플럼토마토 소스",
    toppings = listOf("잘게 조각낸 모짜렐라 치즈")
) {
    override fun cut() {
        println("네모난 모양으로 피자 자르기")
    }
}

class ChicagoStylePepperoniPizza() : Pizza(
    name = "시카고 스타일 페퍼로니 피자",
    dough = "아주 두꺼운 크러스트 도우",
    sauce = "플럼토마토 소스",
    toppings = listOf("잘게 조각낸 모짜렐라 치즈")
) {
    override fun cut() {
        println("네모난 모양으로 피자 자르기")
    }
}

fun main() {
    val nyStore = NYPizzaStore()
    val pizzaFromNyStore: Pizza = nyStore.orderPizza("cheese")
    println("서인이가 주문한 ${pizzaFromNyStore.name} \n")

    val chicagoStore = ChicagoPizzaStore()
    val pizzaFromChicago : Pizza = chicagoStore.orderPizza("veggie")
    println("서인이가 두 번째로 주문한 주문한 ${pizzaFromChicago.name}")
}
