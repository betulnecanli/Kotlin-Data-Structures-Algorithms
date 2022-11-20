package com.betulnecanli.kotlindatastructuresalgorithms.Queue

fun main(){
    arrayListQueue()
    doublyListQueue()

}

    fun arrayListQueue(){
        val queue = ArrayListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        queue.dequeue()
        println(queue)
        //[Ray, Brian, Eric]
        //[Brian, Eric]
        //[Eric]
    }

    fun doublyListQueue(){
        val queue = LinkedListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        queue.dequeue()
        println(queue)
        //Ray --> Brian --> Eric
        //Brian --> Eric
        //Eric
    }
