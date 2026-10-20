package task11

typealias Validator = (String) -> Boolean
typealias Predicate<T> = (T) -> Boolean
typealias Rule = Predicate<String> // Псевдоним по заданию

val isEmail: Validator = { '@' in it && '.' in it.substringAfter('@') }
val isStrongPassword: Validator = { it.length >= 8 && it.any(Char::isDigit) }
val startsWithCode: Rule = { it.startsWith("+998") } // Новое правило проверки

fun check(label: String, input: String, validator: Validator) {
    println("$label: ${if (validator(input)) "OK" else "INVALID"}")
}

fun <T> countMatching(items: List<T>, rule: Predicate<T>): Int = items.count(rule)

fun main() {
    print("E-mail: ")
    val email = readln().trim()
    print("Password: ")
    val password = readln()

    check("E-mail", email, isEmail)
    check("Password", password, isStrongPassword)

    // Проверка списка номеров телефонов по заданию
    val phones = listOf("+998901234567", "+998911112233", "890123456")
    println("Valid Uzbekistan phones: ${countMatching(phones, startsWithCode)}")
}
