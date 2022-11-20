package com.betulnecanli.kotlindatastructuresalgorithms.LinkedList

class LinkedList<T>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty() : Boolean{
        return size == 0
    }

    override fun toString(): String {
        if(isEmpty()){
            return "Empty List"
        }
        else{
            return head.toString()
        }
    }

    //Adds a value at the front of the list
    fun push(value : T){
        head = Node(value = value, next = head)
        if (tail == null){
            //In the case in which you’re pushing into an empty list, the new node is both the head
            //and tail of the list.
            tail = head
        }
        size++
    }

    //Adds a value at the end of the list
     fun append(value: T){
        // Like before, if the list is empty, you’ll need to update both head and tail to the
        //new node. Since append on an empty list is functionally identical to push, you
        //invoke push to do the work for you.
        if(isEmpty()){
            push(value)
            return
        }
        //In all other cases, you create a new node after the current tail node. tail will
        //never be null here because you’ve already handled the case where the list is
        //empty in the if statement
        tail?.next = Node(value = value)
        // Since this is tail-end insertion, your new node is also the tail of the list
        tail = tail?.next
        size++
    }

    //nodeAt() tries to retrieve a node in the list based on the given index. Since you can
    //only access the nodes of the list from the head node, you’ll have to make iterative
    //traversals.
     fun nodeAt(index: Int) : Node<T>?{
        //You create a new reference to head and keep track of the current number of
        //traversals
        var currentNode = head
        var currentIndex = 0

        //Using a while loop, you move the reference down the list until you reach the
        //desired index. Empty lists or out-of-bounds indexes will result in a null return
        //value
        while(currentNode != null && currentIndex<index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    //Adds a value after a particular node of the list
     fun insert(value: T, afterNode : Node<T>) : Node<T>{
        //In the case where this method is called with the tail node, you call the
        //functionally equivalent append method. This takes care of updating tail.
        if(tail == afterNode){
            append(value)
            return tail!!
        }

        //Otherwise, you create a new node and link its next property to the next node of
        //the list.
        val newNode = Node(value = value, next = afterNode.next)

        //You reassign the next value of the specified node to link it to the new node that
        //you just created.
        afterNode.next = newNode
        size++
        return newNode

    }



    //Removes the value at the front of the list
     fun pop() : T?{
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
            if(isEmpty()){
                tail=null
            }
        return result
    }

    //Removes the value at the end of the list
     fun removeLast() : T?{
        //If head is null, there’s nothing to remove, so you return null
        val head = head?:  return null

        //If the list only consists of one node, removeLast is functionally equivalent to
        //pop. Since pop will handle updating the head and tail references, you can
        //delegate this work to the pop function
        if( head.next == null ) return pop()

        //At this point, you know that you’ll be removing a node, so you update the size of
        //the list accordingly.
        size--

        //You keep searching for the next node until current.next is null. This signifies
        //that current is the last node of the list
        var prev  = head
        var current = head
        var next = current.next
        while(next!=null){
            prev = current
            current = next
            next = current.next
        }

        //Since current is the last node, you disconnect it using the prev.next reference.
        //You also make sure to update the tail reference.
        prev.next = null
        tail = prev

        return current.value
    }

    //Removes a value anywhere in the list
     fun removeAfter(node: Node<T>) : T?{

        val result = node.next?.value
        if(node.next == tail){
            tail = node
        }
        if(node.next != null){
            size--
        }
        node.next = node.next?.next
        return result
    }
}