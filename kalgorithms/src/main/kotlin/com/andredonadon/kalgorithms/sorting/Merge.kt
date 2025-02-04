package com.andredonadon.kalgorithms.sorting

fun mergeSort(arr: IntArray, p: Int, r: Int) {
    if (p < r) {
        val q = (p + r) / 2
        mergeSort(arr, p, q)
        mergeSort(arr, q + 1, r)
        merge(arr, p, q, r)
    }
}

fun merge(arr: IntArray, p: Int, q: Int, r: Int) {
    val n1 = q - p + 1
    val n2 = r - q

    val L = IntArray(n1 + 1)
    val R = IntArray(n2 + 1)

    for (i in 0 until n1) {
        L[i] = arr[p + i]
    }
    for (j in 0 until n2) {
        R[j] = arr[q + 1 + j]
    }

    L[n1] = Int.MAX_VALUE
    R[n2] = Int.MAX_VALUE

    var i = 0
    var j = 0

    for (k in p..r) {
        if (L[i] <= R[j]) {
            arr[k] = L[i]
            i++
        } else {
            arr[k] = R[j]
            j++
        }
    }
}

fun main() {
    val array = intArrayOf(12, 15, 7, 9, 2, 5, 1, 10, 4, 8)
    println("Array original: ${array.joinToString(", ")}")
    mergeSort(array, 0, array.size - 1)
    println("Array ordenado: ${array.joinToString(", ")}")
}