import kotlin.random.Random

fun generateRandomEmail(): String {
    return "${generateRandomString(Random.nextInt(30))}@gmail.com";
}

fun generateRandomString(length: Int): String {
    val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}