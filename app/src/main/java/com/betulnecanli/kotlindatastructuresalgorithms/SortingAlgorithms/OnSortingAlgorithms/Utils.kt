package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.OnSortingAlgorithms

fun <T> ArrayList<T>.swapAt(first : Int, second : Int){
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
}