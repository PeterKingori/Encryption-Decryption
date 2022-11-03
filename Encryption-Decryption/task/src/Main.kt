package encryptdecrypt

import java.io.File

const val LENGTH = 26
fun main(args: Array<String>) {
    var algo = ""
    var operation = ""
    var key = 0
    var data = ""
    try {
        algo = if (args.indexOf("-alg") == -1) "shift" else args[args.indexOf("-alg") + 1]
        operation = if (args.indexOf("-mode") == -1) "enc" else args[args.indexOf("-mode") + 1]
        key = if (args.indexOf("-key") == -1) 0 else args[args.indexOf("-key") + 1].toInt()
        data = if (args.indexOf("-data") == -1) {
            if (args.indexOf("-in") == -1) "" else {
                val fileName = args[args.indexOf("-in") + 1]
                File(fileName).readText()
            }
        } else if (args.indexOf("-data") != -1 && args.indexOf("-in") != -1) {
            args[args.indexOf("-data") + 1]
        } else {
            args[args.indexOf("-data") + 1]
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

    val writeFileName = if (args.indexOf("-out") == -1) "" else args[args.indexOf("-out") + 1]

    when (operation) {
        "enc" -> encryption(message = data, key = key, fileName = writeFileName, algo = algo)
        "dec" -> decryption(message = data, key = key, fileName = writeFileName, algo = algo)
        else -> println("One of the inputs is wrong")
    }
}

fun encryption(message: String, key: Int, algo: String, fileName: String) {
    val cypherText = if (algo == "unicode") unicodeAlgo(message, key) else shiftAlgo(message, key)
    if (fileName.isEmpty()) {
        println(cypherText)
    } else {
        File(fileName).writeText(cypherText)
    }
}

fun decryption(message: String, key: Int, algo: String, fileName: String) {
    val decryptedText = if (algo == "unicode") unicodeAlgo(message, -key) else shiftAlgo(message, -key)
    if (fileName.isEmpty()) {
        println(decryptedText)
    } else {
        File(fileName).writeText(decryptedText)
    }
}

// if you are at B and decrypt to move back with key 5 you want to end up at W
fun shiftAlgo(message: String, key: Int): String {
    val alphabetSmall = "abcdefghijklmnopqrstuvwxyz"
    val alphabetCap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val alphabetCapReverse = "ZYXWVUTSRQPONMLKJIHGFEDCBA"
    var newMessage = ""

    for (ch in message) {
        newMessage += if (ch.isUpperCase()) {
            if (key < 0) {
                val index = LENGTH + alphabetCap.indexOf(ch) + key
                alphabetCap[index % LENGTH]
            } else {
                val index = alphabetCap.indexOf(ch)
                alphabetCap[(index + key) % LENGTH]
            }
        } else if (ch.isLowerCase()) {
            if (key < 0) {
                val index = LENGTH + alphabetSmall.indexOf(ch) + key
                alphabetSmall[index % LENGTH]
            } else {
                val index = alphabetSmall.indexOf(ch)
                alphabetSmall[(index + key) % LENGTH]
            }
        } else {
            ch
        }
    }
    return newMessage
}

fun unicodeAlgo(message: String, key: Int): String {
    var newMessage = ""
    message.forEach { newMessage += it + key }
    return newMessage
}
