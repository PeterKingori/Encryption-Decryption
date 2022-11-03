fun main() {
    val input = readln()
    val substring = readln()
    val stringList = input.split(substring)
    println(stringList.lastIndex)
}