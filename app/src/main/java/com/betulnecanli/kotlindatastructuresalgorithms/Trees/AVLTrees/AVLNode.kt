package com.betulnecanli.kotlindatastructuresalgorithms.Trees.AVLTrees

import com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinaryTrees.BinaryNode
import java.lang.Integer.max

class AVLNode<T>(var value : T) {

    var leftChild : AVLNode<T>? = null
    var rightChild : AVLNode<T>? = null

    var height = 0
    val leftHeight : Int
        get() = leftChild?.height ?: 0
    val rightHeight : Int
        get() = rightChild?.height ?: 0

    //The height of the left and right children of each node must differ at most by 1. This is
    //known as the balance factor.
    val balanceFactor : Int
        get() = leftHeight - rightHeight
    //The balanceFactor computes the height difference of the left and right child. If a
    //particular child is null, its height is considered to be -1.

    override fun toString() = diagram(this)

    private fun diagram(node: AVLNode<T>?,
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



}
