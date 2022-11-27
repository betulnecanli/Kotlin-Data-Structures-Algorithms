package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.OnSortingAlgorithms


        /*Selection sort follows the basic idea of bubble sort but improves upon this
        algorithm by reducing the number of swapAt operations. Selection sort only swaps at
        the end of each pass.*/

        fun <T : Comparable<T>> ArrayList<T>.selectionSort(showPasses: Boolean = false){
            if(this.size < 2 ) return
            //1
            for(current in 0 until (this.size - 1)){
                var lowest = current
                //2
                for(other in (current+1) until this.size){
                    if(this[lowest] > this[other]){
                        lowest = other
                    }
                    //3
                    if(lowest != current){
                        this.swapAt(lowest,current)
                    }
                    //4
                    if(showPasses) println(this)
                }
            }
        }
    /*1. You perform a pass for every element in the collection, except for the last one.
    There’s no need to include the last element because if all other elements are in
    their correct order, the last one will be as well.
    2. In every pass, you go through the remainder of the collection to find the element
    with the lowest value.
    3. If that element is not the current element, swap them.
    4. This optional step shows you how the list looks after each step when you call the
    function with showPasses set to true. You can remove this and the parameter
    once you understand the algorithm.*/
