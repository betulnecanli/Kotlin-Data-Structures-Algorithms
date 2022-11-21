package com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinaryTrees

fun main(){
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)
    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight
    val tree = seven

    println(tree)
    //output
    /*
    ┌──null
┌──9
│ └──8
7
│ ┌──5
└──1
 └──0
     */


    tree.traverseInOrder { println(it) }
    //0
    //1
    //5
    //7
    //8
    //9
    tree.traversePreOrder { println(it) }
    //7
    //1
    //0
    //5
    //9
    //8
    tree.traversePostOrder { println(it) }
    //0
    //5
    //1
    //8
    //9
    //7



}