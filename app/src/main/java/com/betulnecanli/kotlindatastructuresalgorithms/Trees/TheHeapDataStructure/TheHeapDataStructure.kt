package com.betulnecanli.kotlindatastructuresalgorithms.Trees.TheHeapDataStructure

//A heap is a complete binary tree data structure also known as a binary heap that
//you can construct using an array.

//Heaps come in two flavors:
//1. Maxheap, in which elements with a higher value have a higher priority.
//2. Minheap, in which elements with a lower value have a higher priority.


/*class ComparableHeapImpl<Element : Comparable<Element>>() :
    AbstractHeap<Element>() {


    companion object {
        fun <Element> create(
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ): Heap<Element> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }
    override fun compare(a: Element, b: Element): Int =
        a.compareTo(b)


}
*/