package com.betulnecanli.kotlindatastructuresalgorithms.SortingAlgorithms.HeapSort

        //Heapsort is another comparison-based algorithm that sorts an array in ascending
        //order using a heap.

        private fun leftChildIndex(index: Int) = (2 * index) + 1
        private fun rightChildIndex(index: Int) = (2 * index) + 2

        fun <T> Array<T>.siftDown(
            index: Int,
            upTo: Int,
            comparator: Comparator<T>
        ) {
            var parent = index
            while (true) {
                val left = leftChildIndex(parent)
                val right = rightChildIndex(parent)
                var candidate = parent
                if (left < upTo &&
                    comparator.compare(this[left], this[candidate]) > 0
                ) {
                    candidate = left
                }
                if (right < upTo &&
                    comparator.compare(this[right], this[candidate]) > 0
                ) {
                    candidate = right
                }
                if (candidate == parent) {
                    return
                }
                this.swapAt(parent, candidate)
                parent = candidate
            }
        }

            fun <T> Array<T>.heapify(comparator: Comparator<T>) {
                if (this.isNotEmpty()) {
                    (this.size / 2 downTo 0).forEach {
                        this.siftDown(it, this.size, comparator)
                    }
                }
            }
            fun <T> Array<T>.heapSort(comparator: Comparator<T>) {
                this.heapify(comparator)
                for (index in this.indices.reversed()) { // 1
                    this.swapAt(0, index) // 2
                    siftDown(0, index, comparator) // 3
                }
            }


                //1. You reorder the elements so that the array looks like a Heap.
                //2. You loop through the array, starting from the last element.
                //3. You swap the first element and the last element. This moves the largest unsorted
                //element to its correct spot.
                //4. Because the heap is now invalid, you must sift down the new root node. As a
                //result, the next largest element will become the new root.

            fun <T> Array<T>.swapAt(first : Int, second : Int){
                val aux = this[first]
                this[first] = this[second]
                this[second] = aux
            }
                //Even though you get the benefit of in-memory sorting, the performance of heap sort
                //is O(n log n) for its best, worse and average cases. This is because you have to
                //traverse the whole array once and, every time you swap elements, you must perform
                //a sift down, which is an O(log n) operation.