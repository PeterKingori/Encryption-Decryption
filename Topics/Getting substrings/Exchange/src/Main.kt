fun main() {
    val input = readln()
    val newString = input.last() + input.substring(1, input.lastIndex) + input[0]
    println(newString)
}