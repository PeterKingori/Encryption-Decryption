fun main() {
    val wordList = readln().split(" ").toList()
    var longestWord = ""
    for (word in wordList) {
        if (word.length > longestWord.length) longestWord = word
    }
    println(longestWord)
}