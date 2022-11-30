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
        node.height = kotlin.math.max(node.leftHeight, node.rightHeight) + 1
        pivot.height = kotlin.math.max(pivot.leftHeight, pivot.rightHeight) + 1
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
        return rightRotate(node)
    }

    private fun leftRightRotate(node : AVLNode<T>) : AVLNode<T>{
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AVLNode<T>) : AVLNode<T>{
        if(node.balanceFactor == 2){
            return if(node.leftChild?.balanceFactor == -1){
                println("left-right")
                leftRightRotate(node)
            }else{
                println("right")
                rightRotate(node)
            }
        }
        else if(node.balanceFactor == -2){
            return if(node.rightChild?.balanceFactor == 1){
                println("right-left")
                rightLeftRotation(node)
            }else{
                println("left")
                leftRotate(node)
            }
        }
        else {
            return node
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
        balancedNode?.height = kotlin.math.max(
            balancedNode?.leftHeight ?: 0,
            balancedNode?.rightHeight ?: 0
        ) + 1
        return balancedNode
    }


    fun remove(value: T){
        root = remove(root, value)
    }
    private fun remove(node : AVLNode<T>?, value :T) : AVLNode<T>?{
        node ?: return null

        when{
            value == node.value ->{
                //In the case in which the node is a leaf node, you simply return null, thereby
                //removing the current node.
                if(node.leftChild == null && node.rightChild == null){
                    return null

                }
                //In the case in which the node is a leaf node, you simply return null, thereby
                //removing the current node.
                if(node.leftChild == null){
                    return node.rightChild

                }
                //If the node has no right child, you return node.leftChild to reconnect the left
                //subtree.
                if(node.rightChild == null){
                    return node.leftChild

                }
                //This is the case in which the node to be removed has both a left and right child.
                //You replace the node’s value with the smallest value from the right subtree. You
                //then call remove on the right child to remove this swapped value
               /* node.rightChild?.min?.value?.let{
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)*/

            }
            value < node.value ->node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        val balancedNode = balanced(node)
        balancedNode.height = max(
            balancedNode.leftHeight,
            balancedNode.rightHeight
        ) + 1
        return balancedNode

    }


}