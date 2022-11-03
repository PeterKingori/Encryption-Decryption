fun main() {
    val dnaString = readln()
    var count = 0
    var encodedSeq = ""
    var currentLetter = dnaString[0]
    for (i in dnaString.indices) {
        if (dnaString[i] == currentLetter) {
            ++count
        } else {
            encodedSeq += currentLetter
            encodedSeq += count
            currentLetter = dnaString[i]
            count = 1
        }
    }
    encodedSeq += currentLetter
    encodedSeq += count
    println(encodedSeq)
}

/** Input the string
 * Take the first letter and store it in a variable
 * Iterate over string checking letters that match the stored variable and increasing the count
 * When they stop matching, append the stored letter to the encodedSeq and its count,
 * change the stored variable and reset the count to zero
 * repeat
 */