package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.RadixSort

fun main(){
    val list = arrayListOf(88, 410, 1772, 20)
    println("Original: $list")
    list.radixSort()
    println("Radix sorted: $list")
}