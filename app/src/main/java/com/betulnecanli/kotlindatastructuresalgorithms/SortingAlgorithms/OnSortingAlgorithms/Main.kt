package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.OnSortingAlgorithms

/*O(n²) time complexity doesn’t have
great performance, but the sorting algorithms in this category are easy to
understand and useful in some scenarios. These algorithms are space-efficient and
only require constant O(1) additional memory space. In this chapter, you’ll look at
the bubble sort, selection sort and insertion sort algorithms.*/


/*These algorithms are
space efficient, and they only require constant O(1) additional memory space. For
small data sets, these sorts compare favorably against more complex sorts.*/

fun main(){
        //bubble sort
        val list  = arrayListOf(9,4,10,3)
        println("original: $list " )
        list.bubbleSort()
        println("Bubble sorted: $list")
        /*original: [9, 4, 10, 3]
                    [4, 9, 3, 10]
                    [4, 3, 9, 10]
                    [3, 4, 9, 10]
          Bubble sorted: [3, 4, 9, 10]*/

}