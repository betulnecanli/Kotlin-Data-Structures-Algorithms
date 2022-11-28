package com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinarySearch

fun main(){
    val array = arrayListOf(1, 5, 15, 17, 19, 22, 24, 31, 105,
        150)
    val search31 = array.indexOf(31)
    val binarySearch31 = array.binarySearch(31)
    println("indexOf(): $search31")
    println("binarySearch(): $binarySearch31")
}