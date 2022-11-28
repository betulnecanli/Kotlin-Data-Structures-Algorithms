package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.QuickSort

//Quicksort is another comparison-based sorting algorithm. Much like merge sort, it
//uses the same strategy of divide and conquer. One important feature of quicksort is
//choosing a pivot point. The pivot divides the list into three partitions:
//[ elements < pivot | pivot | elements > pivot ]

//Choosing a bad pivot can cause quicksort to perform in O(n²).
fun main(){
    val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8,
        -1, 8)
    println("Original: $list")
    list.quicksortLomuto(0, list.size - 1)
    println("Lomuto Sorted: $list")
    list.quicksortHoare( 0, list.size - 1)
    println("Hoare Sorted: $list")
}