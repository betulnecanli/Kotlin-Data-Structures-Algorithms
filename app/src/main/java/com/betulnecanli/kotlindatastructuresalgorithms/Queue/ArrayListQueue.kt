package com.betulnecanli.kotlindatastructuresalgorithms.Queue

class ArrayListQueue<T>: Queue<T> {

    //a generic ArrayListQueue class that implements the Queue
    //interface
    private val list = arrayListOf<T>()

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? = if(isEmpty) null else list.removeAt(0)


    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)

    override fun toString(): String = list.toString()
}