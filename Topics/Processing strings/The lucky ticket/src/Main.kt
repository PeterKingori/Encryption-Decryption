fun main() {
    val ticket = readln()
    var firstThree = 0
    var lastThree = 0
    for (i in 0..2) {
        firstThree += ticket[i].digitToInt()
    }
    for (j in ticket.lastIndex - 2..ticket.lastIndex) {
        lastThree += ticket[j].digitToInt()
    }
    println(if (firstThree == lastThree) "Lucky" else "Regular")
}