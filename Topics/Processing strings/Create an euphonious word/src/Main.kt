const val THREE = 3
fun main() {
    val word = readln()
    val vowels = "aeiouy"
    var consonantsCount = 0
    var vowelsCount = 0
    var insertedLetters = 0

    for (ch in word) {
        if (ch in vowels) {
            vowelsCount++
            consonantsCount = 0
            if (vowelsCount >= THREE) {
                insertedLetters++
                vowelsCount = 1
            }
        } else {
            consonantsCount++
            vowelsCount = 0
            if (consonantsCount >= THREE) {
                insertedLetters++
                consonantsCount = 1
            }
        }
    }
    println(insertedLetters)
}