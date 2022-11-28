package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.QuickSort

        //The naive partitioning creates a new list on every filter function; this is inefficient.
        //All other strategies sort in place.
        fun<T: Comparable<T>> List<T>.quicksortNaive(): List<T> {
            if (this.size < 2) return this // 1
            val pivot = this[this.size / 2] // 2
            val less = this.filter { it < pivot } // 3
            val equal = this.filter { it == pivot }
            val greater = this.filter { it > pivot }
            return less.quicksortNaive() + equal +
                    greater.quicksortNaive() // 4
        }
            //1. There must be more than one element in the list. If not, the list is considered
            //sorted.
            //2. Pick the middle element of the list as your pivot.
            //3. Using the pivot, split the original list into three partitions. Elements less than,
            //equal to or greater than the pivot go into different buckets.
            //4. Recursively sort the partitions and then combine them.