package com.andredonadon.kalgorithms.string

fun encodeRLE(input: String) : String {
    if (input.isEmpty()) return ""

    val encoded = StringBuilder()
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == input[i-1]) {
            count++
        } else {
            encoded.append("${input[i-1]}$count")
            count = 1
        }
    }

    encoded.append("${input.last()}$count")

    return encoded.toString()
}

fun decodeRLE(encoded: String) : String {
    if (encoded.isEmpty()) return ""

    val regex = Regex("([a-zA-Z ])([0-9]+)")
    val decoded = StringBuilder()

    regex.findAll(encoded).forEach { match ->
        val char = match.groupValues[1]
        val count = match.groupValues[2].toInt()
        decoded.append(char.repeat(count))
    }

    return decoded.toString()
}

fun removeConsecutiveDuplicates(input: String) : String {
    if (input.isEmpty()) return ""

    val result = StringBuilder()
    result.append(input[0])

    for (i in 1 until input.length) {
        if (input[i] != input[i-1]) {
            result.append(input[i])
        }
    }

    return result.toString()
}

fun main() {
    val original = "aannndrrrrreeeee lluuuiiiizzzzzzz"
    val compressed = encodeRLE(original)
    val decompressed = decodeRLE(compressed)
    val reduced = removeConsecutiveDuplicates(original)


    println("Original:    $original")
    println("Compactado:  $compressed")
    println("Descompactado: $decompressed")
    println("Reduzido: $reduced")
    println("Reconstrução correta? ${original == decompressed}")
}