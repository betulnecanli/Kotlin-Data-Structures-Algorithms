package com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinarySearchTrees

fun main(){
    val bst = BinarySearchTree<Int>()
    (0..4).forEach {
        bst.insert(it)
    }
    println(bst)
    //output:
    //   ┌──4
    //  ┌──3
    //  │ └──null
    // ┌──2
    // │ └──null
    //┌──1
    //│ └──null
    //0
    //└──null
}