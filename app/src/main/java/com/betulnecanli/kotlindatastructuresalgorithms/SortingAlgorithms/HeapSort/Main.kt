package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.HeapSort

fun main(){
    val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
    array.heapSort()
    print(array.joinToString())
}