package com.betulnecanli.kotlindatastructuresalgorithms.Trees.AVLTrees


    val tree = AVLTree<Int>()
    fun main(){
        insert()
                }

    fun insert(){
        /*(0..14).forEach {
            tree.insert(value = it)
        }
        print(tree)*/
        tree.insert(15)
        tree.insert(10)
        tree.insert(16)
        tree.insert(18)
        print(tree)
        tree.remove(10)
        print(tree)
    }