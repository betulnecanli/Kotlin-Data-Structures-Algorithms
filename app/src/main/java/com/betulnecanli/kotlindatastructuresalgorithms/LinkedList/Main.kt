package com.betulnecanli.kotlindatastructuresalgorithms.LinkedList

fun main(){
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)
    node1.next = node2
    node2.next = node3
    println(node1)
    //output : 1 --> 2 --> 3

    push()
    append()
    insertAt()
    pop()
    removeLast()
    removeAfter()
}

    fun push(){

        val list = LinkedList<Int>()
        list.push(5)
        list.push(6)
        list.push(9)
        println(list)
        //output : 9 --> 6 --> 5
    }

    fun append(){

        val list2 = LinkedList<Int>()
        list2.append(1)
        list2.append(2)
        list2.append(3)
        println(list2)
        //output : 1 -> 2 -> 3
    }

    fun insertAt(){
        val list3 = LinkedList<Int>()
        list3.push(3)
        list3.push(2)
        list3.push(1)
        println("Before inserting: $list3")
        var middleNode = list3.nodeAt(1)!!
        for (i in 1..3) {
            middleNode = list3.insert(-1 * i, middleNode)
        }
        println("After inserting: $list3")
        //Before inserting: 1 -> 2 -> 3
        //After inserting: 1 -> 2 -> -1 -> -2 -> -3 -> 3
    }

    fun pop(){
        val list4 = LinkedList<Int>()
        list4.push(3)
        list4.push(2)
        list4.push(1)
        println("Before popping list: $list4")
        val poppedValue = list4.pop()
        println("After popping list: $list4")
        println("Popped value: $poppedValue")
        //Before popping list: 1 -> 2 -> 3
        //After popping list: 2 -> 3
        //Popped value: 1
    }

    fun removeLast(){
        val list5 = LinkedList<Int>()
        list5.push(3)
        list5.push(2)
        list5.push(1)
        println("Before removing last node: $list5")
        val removedValue = list5.removeLast()
        println("After removing last node: $list5")
        println("Removed value: $removedValue")
        //Before removing last node: 1 -> 2 -> 3
        //After removing last node: 1 -> 2
        //Removed value: 3
    }

    fun removeAfter(){
        val list6 = LinkedList<Int>()
        list6.push(3)
        list6.push(2)
        list6.push(1)
        println("Before removing at particular index: $list6")
        val index = 1
        val node = list6.nodeAt(index - 1)!!
        val removedValue2 = list6.removeAfter(node)
        println("After removing at index $index: $list6")
        println("Removed value: $removedValue2")
        //Before removing at particular index: 1 -> 2 -> 3
        //After removing at index 1: 1 -> 3
        //Removed value: 2
    }
