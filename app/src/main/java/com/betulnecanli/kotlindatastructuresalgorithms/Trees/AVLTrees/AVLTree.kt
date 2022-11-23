package com.betulnecanli.kotlindatastructuresalgorithms.Trees.AVLTrees

import com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinaryTrees.BinaryNode
import java.lang.Math.max

class AVLTree<T : Comparable<T>>() {
    var root : AVLNode<T>? = null

    override fun toString() = root?.toString() ?: "empty tree"

    private fun leftRotate(node : AVLNode<T>) : AVLNode<T>{
        //The right child is chosen as the pivot. This node replaces the rotated node as the
        //root of the subtree (it moves up a level)
        val pivot  = node.rightChild!!
        //The node to be rotated becomes the left child of the pivot (it moves down a
        //level). This means that the current left child of the pivot must be moved
        //elsewhere.
        node.rightChild = pivot.leftChild
        //The pivot’s leftChild can now be set to the rotated node.
        pivot.leftChild = node
        //You update the heights of the rotated node and the pivot.
        node.height = Integer.max(node.leftHeight, node.rightHeight) + 1
        pivot.height = Integer.max(pivot.leftHeight, pivot.rightHeight) + 1
        //Finally, you return the pivot so that it can replace the rotated node in the tree
        return pivot
    }

    private fun rightRotate(node : AVLNode<T>) : AVLNode<T>{
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = Integer.max(node.leftHeight, node.rightHeight) + 1
        pivot.height = Integer.max(pivot.height, pivot.rightHeight) + 1
        return pivot
    }


    private fun rightLeftRotation(node: AVLNode<T>): AVLNode<T>{
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node : AVLNode<T>) : AVLNode<T>{
        val leftChild = node.leftChild ?: return node
        node.leftChild = rightRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AVLNode<T>) : AVLNode<T>{
        return when (node.balanceFactor){
            2 -> {
                if(node.leftChild?.balanceFactor == -1){
                    leftRightRotate(node)
                }else{
                    rightRotate(node)
                }
            }
            -2 -> {
                if(node.rightChild?.balanceFactor == 1){
                    rightLeftRotation(node)
                }else{
                    leftRotate(node)
                }
            }
            else -> node
        }
    }

    fun insert(value : T){
        root = insert(root, value)
    }



     private fun insert(node: AVLNode<T>?, value :T ) : AVLNode<T>?{
        node ?: return AVLNode(value)
        if(value < node.value){
            node.leftChild = insert(node.leftChild, value)
        }
        else{
            node.rightChild = insert(node.rightChild, value)
        }
        val balancedNode = balanced(node)
        balancedNode?.height = max(balancedNode?.leftHeight ?: 0,
                                    balancedNode?.rightHeight ?: 0) + 1
        return balancedNode
    }


    fun remove(value: T){
        root = remove(root, value)
    }
    private fun remove(node : AVLNode<T>?, value :T) : AVLNode<T>?{
        node ?: return null


    }

}