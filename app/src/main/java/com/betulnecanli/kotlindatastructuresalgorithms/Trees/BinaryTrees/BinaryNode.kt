package com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinaryTrees

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T>(val value: T) {
    var leftChild : BinaryNode<T>? = null
    var rightChild : BinaryNode<T>? = null


    override fun toString() = diagram(this)

    private fun diagram(node: BinaryNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    // If the current node has a left child, recursively visit this child first.
    // Then visit the node itself.
    // If the current node has a right child, recursively visit this child.
    fun traverseInOrder(visit: Visitor<T>){
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    // Visits the current node first.
    // Recursively visits the left and right child.
    fun traversePreOrder(visit : Visitor<T>){
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    // Recursively visits the left and right child.
    // Only visits the current node after the left and right child have been visited
    //recursively.
    fun traversePostOrder(visit : Visitor<T>){
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    //Each one of these traversal algorithms has both a time and space complexity of O(n).
 }