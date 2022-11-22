package com.betulnecanli.kotlindatastructuresalgorithms.Trees.BinarySearchTrees


val bst = BinarySearchTree<Int>()
fun main(){

    //Inserting elements
    insert()
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

    //Finding elements
    find()
    //output : Couldn't find 5


    //Removing elements
    remove()
    //Tree before removal:
    //   ┌──4
    //  ┌──3
    //  │ └──null
    // ┌──2
    // │ └──null
    //┌──1
    //│ └──null
    //0
    //└──null
    //
    //Tree after removing root:
    //  ┌──4
    // ┌──2
    // │ └──null
    //┌──1
    //│ └──null
    //0
    //└──null
    //
    //
    //Process finished with exit code 0

}

    fun insert(){
        (0..4).forEach {
            bst.insert(it)
        }
        println(bst)
    }

    fun find(){
        if (bst.contains(5)) {
            println("Found 5!")
        } else {
            println("Couldn't find 5")
        }
    }


    fun remove(){
        println("Tree before removal:")
        println(bst)
        bst.remove(3)
        println("Tree after removing root:")
        println(bst)
    }

