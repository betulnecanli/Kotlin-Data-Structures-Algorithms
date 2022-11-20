package com.betulnecanli.kotlindatastructuresalgorithms.DoublyLinkedList

class DoublyLinkedList<T> {
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    private var size = 0

    fun isEmpty() :Boolean{
        return size == 0
    }

    override fun toString(): String {
        return if(isEmpty()){
            "Empty List"
        }
        else {
            "${head.toString()}"
        }
    }

    // Add a node at the front
    fun push(value : T){
        head = Node(value = value, prev = null, next = head)
        if(tail == null){
            tail = head
        }
        head!!.next?.prev =head
        size++
    }

    // //Adds a value at the end of the list
    fun append(value: T){
        if(isEmpty()){
            push(value)
            return
        }

        tail?.next = Node(value = value, prev = tail, next = null)
        tail = tail?.next
        size++
    }

    //nodeAt() tries to retrieve a node in the list based on the given index.
    fun nodeAt(index : Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while(currentNode != null && currentIndex<index){
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode

    }


    //Add a node after a given node
    fun insert(value : T, afterNode: Node<T>) : Node<T>{
        //In the case where this method is called with the tail node, you call the
        //functionally equivalent append method. This takes care of updating tail.
        if(tail == afterNode){
            append(value)
            return tail!!
        }

        //Otherwise, you create a new node and link its next property to the next node of
        //the list.
        val newNode = Node(value= value, prev = afterNode, next = afterNode.next)


        afterNode.next?.prev = newNode
        afterNode.next = newNode

        size++
        return newNode
    }

    //Add a node before a given node
    fun insertBefore(value: T, beforeNode : Node<T>) : Node<T>{
        //In the case where this method is called with the head node, you call the
        //functionally equivalent push method. This takes care of updating head.
        if(head==beforeNode){
            push(value)
            return head!!
        }


        val newNode = Node(value = value, next = beforeNode,prev = beforeNode.prev)

        beforeNode.prev = newNode
        newNode.prev?.next = newNode
        size++

        return newNode

    }

    //Removes the value at the front of the list
    fun pop(): T?{
        if(!isEmpty()) size--
        val result = head?.value
        head = head?.next
        head?.prev = null
        return result
    }

    //Removes the value at the end of the list
    fun removeLast() : T?{
        val head = head?: return null

        if(head.next == null) return pop()

        size--

        var _prev = head
        var current = head
        var next = current.next
        while(next != null){
            _prev = current
            current = next
            next = current.next
        }

        _prev.next=null
        tail=_prev
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
        node.next?.prev = node

        return result

    }


    fun removeBefore(node: Node<T>): T?{
        val result = node.prev?.value

        if(node.prev == head){
            head=node
        }
        if(node.prev != null){
            size--
        }

        node.prev?.prev?.next = node
        node.prev = node.prev?.prev


        return result

    }

 }