fun main() {
    val (input, n) = readln().split(" ")

    if (n.toInt() > input.length) {
        println(input)
    } else {
        val firstChars = input.substring(0, n.toInt())
        val lastChars = input.substring(n.toInt())
        println(lastChars + firstChars)
    }
}