package com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinarySearchTrees

import com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinaryTrees.BinaryNode

class BinarySearchTree<T: Comparable<T>>() {
    var root : BinaryNode<T>? = null

    override fun toString() = root?.toString() ?: "empty tree"

    fun insert(value: T){
        root = insert(root ,value)
    }
    private fun insert(node : BinaryNode<T>?,
                        value: T
                       ): BinaryNode<T>{
        node ?: return BinaryNode(value)
        if(value < node.value){
            node.leftChild = insert(node.leftChild, value)

        }
        else{
            node.rightChild = insert(node.rightChild, value)
        }
        return node

    }

    //Finding an element in a BST requires you to traverse through its nodes.
    fun contains(value : T ):  Boolean{
        root ?:return false

        var found  = false
        root?.traverseInOrder {
            if(value == it){
                found = true
            }
        }
        return found
    }


    //Optimizing contains
    fun optContains(value : T) : Boolean{
        //Start by setting current to the root node.
        var current = root

        //While current is not null, check the current node’s value.
        //This implementation of contains is an O(log n) operation in a balanced binary
        //search tree.
        while (current != null){
            //If the value is equal to what you’re trying to find, return true
            if(current.value == value){
                return true
            }

            //Otherwise, decide whether you’re going to check the left or right child.
            current = if (value < current.value){
                current.leftChild
            }
            else{
                current.rightChild
            }
        }
        return false
    }

    //Removing elements

    //Case 1: Leaf node
    //Removing a leaf node is straightforward; simply detach the leaf node.
    //Case 2: Nodes with one child
    //When removing nodes with one child, you need to reconnect that one child with the
    //rest of the tree.
    //Case 3: Nodes with two children
    //When removing a node with two children, replace the node you removed with the
    //smallest node in its right subtree. Based on the rules of the BST, this is the leftmost
    //node of the right subtree.
    fun remove(value: T){
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?,
                       value: T) : BinaryNode<T>?{
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
                node.rightChild?.min?.value?.let{
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)

            }
            value < node.value ->node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }






}