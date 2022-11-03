fun main() {
    val number = readln()
    var firstHalf = 0
    var lastHalf = 0
    for (i in 0 until number.length / 2) {
        firstHalf += number[i].digitToInt()
    }
    for (j in number.length / 2..number.lastIndex) {
        lastHalf += number[j].digitToInt()
    }
    println(if (firstHalf == lastHalf) "YES" else "NO")
}