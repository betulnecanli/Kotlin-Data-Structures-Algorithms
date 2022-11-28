package com.betulnecanli.kotlindatastructuresalgorithms.Trees.TheHeapDataStructure

fun main(){
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1
    val priorityQueue = ComparableHeapImpl.create(array) // 2
    while (!priorityQueue.isEmpty) { // 3
        println(priorityQueue.remove())
    }
}