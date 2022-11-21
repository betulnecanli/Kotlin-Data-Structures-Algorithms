package com.betulnecanli.kotlindatastructuresalgorithms.Trees

import com.betulnecanli.kotlindatastructuresalgorithms.LinkedList.LinkedList
import com.betulnecanli.kotlindatastructuresalgorithms.Queue.LinkedListQueue
import com.betulnecanli.kotlindatastructuresalgorithms.Queue.Queue


class TreeNode<T>(val value: T) {
    private val children : MutableList<TreeNode<T>> = mutableListOf()


    //This method adds a child node to a node.
    fun add(child : TreeNode<T>) = children.add(child)


    //Depth-first traversal starts at the root node and explores the tree as far as possible
    //along each branch before reaching a leaf and then backtracking.
    //This simple code uses recursion to process the next node.
    fun forEachDepthFirst(visit: Visitor<T>){
        visit(this)
        children.forEach{
            it.forEachDepthFirst(visit)
        }
    }

    //Level-order traversal is a technique that visits each node of the tree based on the
    //depth of the nodes. Starting at the root, every node on a level is visited before going
    //to a lower level.
    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = LinkedListQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }


    fun search(value : T ): TreeNode<T>?{
        var result : TreeNode<T>? = null
        forEachLevelOrder {
            if(it.value == value){
                result = it
            }
        }
        return result
    }

}

typealias Visitor<T> = (TreeNode<T>) -> Unit