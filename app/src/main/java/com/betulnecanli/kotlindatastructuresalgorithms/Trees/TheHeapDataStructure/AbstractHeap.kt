package com.betulnecanli.kotlindatastructuresalgorithms.Trees.TheHeapDataStructure

import java.util.*
import java.util.Collections.sort
import kotlin.collections.ArrayList

interface Collection<Element> {
            val count: Int
                get
            val isEmpty: Boolean
                get() = count == 0
            fun insert(element: Element)
            fun remove(): Element?
            fun remove(index: Int): Element?
        }
        interface Heap<Element> : Collection<Element> {
            fun peek(): Element?
        }
        abstract class AbstractHeap<Element>() : Heap<Element> {
            abstract fun compare(a: Element, b: Element): Int
            var elements: ArrayList<Element> = ArrayList<Element>()
            override val count: Int
                get() = elements.size
            override fun peek(): Element? = elements.first()
            private fun leftChildIndex(index: Int) = (2 * index) + 1
            private fun rightChildIndex(index: Int) = (2 * index) + 2
            private fun parentIndex(index: Int) = (index - 1) / 2
            override fun insert(element: Element) {
                elements.add(element) // 1
                siftUp(count - 1) // 2
            }
            //1. insert appends the element to the array and then performs a sift up.
            //2. siftUp swaps the current node with its parent, as long as that node has a higher
            //priority than its parent.

            //Complexity: The overall complexity of insert() is O(log n). Appending an
            //element in an array takes only O(1), while sifting up elements in a heap takes
            //O(log n).

            private fun siftUp(index: Int) {
                var child = index
                var parent = parentIndex(child)
                while (child > 0 && compare(elements[child], elements[parent])
                    > 0) {
                    Collections.swap(elements, child, parent)
                    child = parent
                    parent = parentIndex(child)
                }
            }

            //Complexity: The overall complexity of remove() is O(log n). Swapping
            //elements in an array takes only O(1), while sifting down elements in a heap
            //takes O(log n) time.
            override fun remove(): Element? {
                if (isEmpty) return null // 1
                Collections.swap(elements, 0, count - 1) // 2
                val item = elements.removeAt(count - 1) // 3
                siftDown(0) // 4
                return item
            }
            //1. Check to see if the heap is empty. If it is, return null.
            //2. Swap the root with the last element in the heap.
            //3. Remove the last element (the maximum or minimum value) and return it.
            //4. The heap may not be a maxheap or minheap anymore, so you must perform a sift
            //down to make sure it conforms to the rules.

            private fun siftDown(index: Int) {
                var parent = index // 1
                while (true) { // 2
                    val left = leftChildIndex(parent) //3
                    val right = rightChildIndex(parent)
                    var candidate = parent // 4
                    if (left < count &&
                        compare(elements[left], elements[candidate]) > 0) {
                        candidate = left //5
                    }
                    if (right < count &&
                        compare(elements[right], elements[candidate]) > 0) {
                        candidate = right // 6
                    }
                    if (candidate == parent) {
                        return // 7
                    }
                    Collections.swap(elements, parent, candidate) // 8
                    parent = candidate
                }
            }
            //1. Store the parent index.
            //2. Continue sifting until you return.
            //3. Get the parent’s left and right child index.
            //4. candidate is used to keep track of which index to swap with the parent.
            //5. If there’s a left child, and it has a higher priority than its parent, make it the
            //candidate.
            //6. If there’s a right child, and it has an even greater priority, it will become the
            //candidate instead.
            //7. If candidate is still parent, you have reached the end, and no more sifting is
            //required.
            //8. Swap candidate with parent and set it as the new parent to continue sifting.


            //Complexity: Removing an arbitrary element from a heap is an O(log n)
            //operation.
            override fun remove(index: Int): Element? {
                if (index >= count) return null // 1
                return if (index == count - 1) {
                    elements.removeAt(count - 1) // 2
                } else {
                    Collections.swap(elements, index, count - 1) // 3
                    val item = elements.removeAt(count - 1) // 4
                    siftDown(index) // 5
                    siftUp(index)
                    item
                }
            }
            //1. Check to see if the index is within the bounds of the array. If not, return null.
            //2. If you’re removing the last element in the heap, you don’t need to do anything
            //special. Simply remove and return the element.
            //3. If you’re not removing the last element, first swap the element with the last
            //element.
            //4. Then, return and remove the last element.
            //5. Finally, perform both a sift down and a sift up to adjust the heap.

            //Complexity: To search for an element in a heap is, in the worst-case, an O(n)
            //operation, since you may have to check every element in the array:
            private fun index(element: Element, i: Int): Int? {
                if (i >= count) {
                    return null // 1
                }
                /*if (sort(element, elements[i])) {
                    return null // 2
                }*/
                if (element == elements[i]) {
                    return i // 3
                }
                val leftChildIndex = index(element, leftChildIndex(i))
                if (leftChildIndex != null) return leftChildIndex // 4
                val rightChildIndex = index(element, rightChildIndex(i))
                if (rightChildIndex != null) return rightChildIndex // 5
                return null // 6
            }
            //1. If the index is greater than or equal to the number of elements in the array, the
            //search failed. Return null.
            //2. Check to see if the element that you’re looking for has higher priority than the
            //current element at index i. If it does, the element you’re looking for cannot
            //possibly be lower in the heap.
            //3. If the element is equal to the element at index i, return i.
            //4. Recursively search for the element starting from the left child of i.
            //5. Recursively search for the element starting from the right child of i.
            //6. If both searches failed, the search failed. Return null.

}