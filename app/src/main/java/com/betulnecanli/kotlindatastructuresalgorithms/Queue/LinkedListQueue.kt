package com.betulnecanli.kotlindatastructuresalgorithms.Queue

import com.betulnecanli.kotlindatastructuresalgorithms.DoublyLinkedList.DoublyLinkedList

class LinkedListQueue<T> : Queue<T> {

    private val list = DoublyLinkedList<T>()

    private var size = 0

    override fun enqueue(element: T): Boolean {
       list.append(element)
        size++
        return true
    }

    override fun dequeue(): T? {

        val firstNode = list.nodeAt(0) ?: return null
        list.pop()
        size--
        return firstNode.value
    }

    override val count: Int
        get() = size

    override fun peek(): T? = list.nodeAt(0)?.value

    override fun toString(): String = list.toString()
}