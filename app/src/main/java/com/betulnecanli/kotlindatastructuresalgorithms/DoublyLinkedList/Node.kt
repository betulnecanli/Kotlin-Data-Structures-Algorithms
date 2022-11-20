package com.betulnecanli.kotlindatastructuresalgorithms.DoublyLinkedList

data class Node<T>(var value: T,
                   var next : Node<T>? = null,
                   var prev : Node<T>? = null
){
    override fun toString(): String {
        return if(next != null){
            "$value --> ${next.toString()}"
        }
        else{
            "$value"
        }

    }
}