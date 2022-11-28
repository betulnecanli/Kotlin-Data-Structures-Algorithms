package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.MergeSort

fun main(){
    val list = listOf(7, 2, 6, 3, 9)
    println("Original: $list")
    val result = list.mergeSort()
    println("Merge sorted: $result")
}