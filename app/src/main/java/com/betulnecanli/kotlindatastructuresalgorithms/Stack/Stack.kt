package com.betulnecanli.kotlindatastructuresalgorithms.Stack

import com.betulnecanli.kotlindatastructuresalgorithms.LinkedList.append
import kotlin.coroutines.CoroutineContext

interface Stack<Element> {

    fun push(e : Element)

    fun pop(): Element?

    fun peek(): Element?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count ==0
}

class StackImpl<T: Any>(): Stack<Any>{

    //You defines a private property of type ArrayList for the data and you override the
    //toString method in order to display its content for debug purposes
    private val storage  = arrayListOf<Any>()

    override fun toString(): String = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }


    override fun push(e: Any) {
        storage.add(e)
    }

    override fun pop(): Any? {
        if(storage.size == 0){
            return null
        }
        return  storage.removeAt(storage.size-1)
    }

    //peek is an operation that’s often attributed to the stack interface. The idea of peek is
    //to look at the top element of the stack without mutating its contents.
    override fun peek(): Any? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size
    //This allows you to have a cleaner code changing the implementation of the pop
    //method like this:
    /*
    override fun pop(): Element? {
        if (isEmpty) {
         return null
            }
            return storage.removeAt(count - 1)
            }
   */

}