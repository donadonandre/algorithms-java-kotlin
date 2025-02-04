package com.andredonadon.kalgorithms.sorting

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i -1

        while (j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j]
            j--
        }

        arr[j+1] = key
    }
}

fun main() {
    val arr = intArrayOf(5, 2, 4, 6, 1, 3, 9, 7)

    println("Array original: ${arr.joinToString(", ")}")

    insertionSort(arr)

    println("Array ordenado: ${arr.joinToString(", ")}")
}