package com.betulnecanli.kotlindatastructuresalgorithms.Queue

interface Queue<T> {

    // Inserts an element at the back of the queue and returns true if the
    //operation is successful
    fun enqueue(element : T) : Boolean


    // Removes the element at the front of the queue and returns it
    fun dequeue() : T?

    val count : Int
        get

    val isEmpty: Boolean
        get() = count == 0

    //Returns the element at the front of the queue without removing it
    fun peek(): T?
}

