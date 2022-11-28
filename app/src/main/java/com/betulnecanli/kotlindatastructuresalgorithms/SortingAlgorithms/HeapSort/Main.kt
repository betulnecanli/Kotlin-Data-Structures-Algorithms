package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.HeapSort

fun main(){
    val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
    val ascending = Comparator { first: Int, second: Int ->
        when {
            first < second -> -1
            first > second -> 1
            else -> 0
        }
    }
    array.heapSort(ascending)
    print(array.joinToString())
}

        //The current example of heap sort sorts the elements in ascending order. How would
        //you sort in descending order?
        /*val descending = Comparator { first: Int, second: Int ->
         when {
         first < second -> 1
         first > second -> -1
         else -> 0
         }
        }*/

