package com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinarySearch

//Binary search is one of the most efficient searching algorithms with a time
//complexity of O(log n). This is comparable with searching for an element inside a
//balanced binary search tree.
//Two conditions need to be met before you can use binary search:
//• The collection must be able to perform index manipulation in constant time.
//Kotlin collections that can do this include the Array and the ArrayList.
//• The collection must be sorted.

        //You want binarySearch to be available on any ArrayList, so you define it as a
        //generic extension function.
        fun <T : Comparable<T>> ArrayList<T>.binarySearch(
            value: T,
            range: IntRange = indices //Binary search is recursive,
            // so you need to be able to pass in a range to search.
        //The parameter range is made optional by giving it a default value; this lets you start
        //the search without having to specify a range. In this case, the indices property
        //of ArrayList is used, which covers all valid indexes of the collection.
        ): Int? {
        // 1
            if (range.first > range.last) {
                return null
            }
        // 2
            val size = range.last - range.first + 1
            val middle = range.first + size / 2
            return when {
                // 3
                this[middle] == value -> middle
                // 4
                this[middle] > value -> binarySearch(value, range.first until
                        middle)
                else -> binarySearch(value, (middle + 1)..range.last)
            }
        }
        //1. First, you check if the range contains at least one element. If it doesn’t, the
        //search has failed and you return null.
        //2. Now that you’re sure you have elements in the range, you find the middle index
        //in the range.
        //3. You then compare the value at this index with the value you’re searching for. If
        //they match, you return the middle index.
        //4. If not, you recursively search either the left or right half of the collection,
        //excluding the middle item in both cases.