package com.betulnecanli.kotlindatastructuresalgorithms.DoublyLinkedList

import com.betulnecanli.kotlindatastructuresalgorithms.LinkedList.LinkedList

fun main(){
      /*  push()
        append()
        insert()
        insertBefore()
        pop()
        removeLast()
        removeAfter()*/
        removeBefore()
    }


    private fun push(){
        val list = DoublyLinkedList<Int>()
        list.push(5)
        list.push(6)
        list.push(9)
        println(list)
    }

    private fun append(){
        val list2 = DoublyLinkedList<Int>()
        list2.append(1)
        list2.append(2)
        list2.append(3)
        println(list2)
        //output : 1 -> 2 -> 3
    }

    private fun insert(){
        val list3 = DoublyLinkedList<Int>()
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

    private fun insertBefore(){
        val list4 = DoublyLinkedList<Int>()
        list4.push(3)
        list4.push(2)
        list4.push(1)
        println("Before inserting: $list4")
        var middleNode = list4.nodeAt(1)!!
        for (i in 1..3) {
            middleNode = list4.insertBefore(-1 * i, middleNode)
        }
        println("After inserting: $list4")
        //Before inserting: 1 --> 2 --> 3
        //After inserting: 1 --> -3 --> -2 --> -1 --> 2 --> 3
    }

        private fun pop(){
            val list4 = DoublyLinkedList<Int>()
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
            val list5 = DoublyLinkedList<Int>()
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
            val list6 = DoublyLinkedList<Int>()
            list6.push(3)
            list6.push(2)
            list6.push(1)
            list6.push(6)
            list6.push(7)
            println("Before removing at particular index: $list6")
            val node = list6.nodeAt(2)!!
            val removedValue2 = list6.removeAfter(node)
            println("After removing : $list6")
            println("Removed value: $removedValue2")
            //Before removing at particular index: 7 --> 6 --> 1 --> 2 --> 3
            //After removing : 7 --> 6 --> 1 --> 3
            //Removed value: 2

        }

        fun removeBefore(){
            val list6 = DoublyLinkedList<Int>()
            list6.push(3)
            list6.push(2)
            list6.push(1)
            list6.push(6)
            list6.push(7)
            println("Before removing at particular index: $list6")
            val node = list6.nodeAt(2)!!
            val removedValue2 = list6.removeBefore(node)
            println("After removing : $list6")
            println("Removed value: $removedValue2")
            //Before removing at particular index: 7 --> 6 --> 1 --> 2 --> 3
            //After removing : 7 --> 1 --> 2 --> 3
            //Removed value: 6
        }