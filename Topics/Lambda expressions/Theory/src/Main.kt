import java.io.File

// You can experiment here, it won’t be checked

fun main() {
    val fileName = "/Users/peterkingori/Downloads/words_with_numbers.txt"
    val lines = File(fileName).readLines()
    var count = 0
    for (line in lines) {
        if (line.toIntOrNull() != null) count++
    }
    println(count)
    println(File(fileName).readLines().size)
    println(File(fileName).length())
}