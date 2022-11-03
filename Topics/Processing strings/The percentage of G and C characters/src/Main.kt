const val HUNDRED = 100
fun main() {
    val sequence = readln()
    var count = 0.0
    for (ch in sequence) {
        if (ch.equals('g', true) || ch.equals('c', true)) count++
    }
    val result = count / sequence.length * HUNDRED
    println(result)
}