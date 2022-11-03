fun main() {
    val input = readln()
    val length = input.length
    var mid = ""
    if (length % 2 == 0) {
        mid += input[length / 2 - 1]
        mid += input[length / 2]
        println(input.replaceFirst(oldValue = mid, newValue = ""))
    } else {
        mid += input[length / 2]
        println(input.replaceFirst(oldValue = mid, newValue = ""))
    }
}