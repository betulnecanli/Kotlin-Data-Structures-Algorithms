package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.MergeSort

    //Merge sort is one of the most efficient sorting algorithms. With a time complexity of
    //O(n log n), it’s one of the fastest of all general-purpose sorting algorithms. The idea
    //behind merge sort is divide and conquer — to break a big problem into several
    //smaller, easier-to-solve problems, and then combine those solutions into a final
    //result. The merge sort mantra is to split first and merge after.

        private fun <T : Comparable<T>> merge(left: List<T>, right:
        List<T>): List<T> {
            // 1
            var leftIndex = 0
            var rightIndex = 0
            // 2
            val result = mutableListOf<T>()
            // 3
            while (leftIndex < left.size && rightIndex < right.size) {
                val leftElement = left[leftIndex]
                val rightElement = right[rightIndex]
                // 4
                if (leftElement < rightElement) {
                    result.add(leftElement)
                    leftIndex += 1
                } else if (leftElement > rightElement) {
                    result.add(rightElement)
                    rightIndex += 1
                } else {
                    result.add(leftElement)
                    leftIndex += 1
                    result.add(rightElement)
                    rightIndex += 1
                }
            }
            // 5
            if (leftIndex < left.size) {
                result.addAll(left.subList(leftIndex, left.size))
            }
            if (rightIndex < right.size) {
                result.addAll(right.subList(rightIndex, right.size))
            }
            return result
        }

            //1. The leftIndex and rightIndex variables track your progress as you parse
            //through the two lists.
            //2. The result list will house the combined lists.
            //3. Starting from the beginning, you compare the elements in the left and right
            //lists sequentially. When you reach the end of either list, there’s nothing else to
            //compare.
            //4. The smaller of the two elements goes into the result list. If the elements are
            //equal, they can both be added.
            //5. The first loop guarantees that either left or right is empty. Since both lists are
            //sorted, this ensures that the leftover elements are greater than or equal to the
            //ones currently in result. In this scenario, you can add the rest of the elements
            //without comparison.

        fun <T : Comparable<T>> List<T>.mergeSort(): List<T> {
            if (this.size < 2) return this
            val middle = this.size / 2
            val left = this.subList(0, middle).mergeSort()
            val right = this.subList(middle, this.size).mergeSort()
            return merge(left, right)
        }
            //The best, worst and average time complexity of merge sort is O(n log n).