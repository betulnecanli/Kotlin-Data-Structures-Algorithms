package com.betulnecanli.kotlindatastructuresalgorithms.Trees

fun main(){
    val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")
    val beverages = TreeNode("Beverages").run {
        add(hot)
        add(cold)
    }

    //Depth-first traversal starts at the root node and explores the tree as far as possible
    //along each branch before reaching a leaf and then backtracking.
    val tree = makeBeverageTree()
    tree.forEachDepthFirst { println(it.value) }

    //Level-order traversal is a technique that visits each node of the tree based on the
    //depth of the nodes. Starting at the root, every node on a level is visited before going
    //to a lower level.
    val tree2 = makeBeverageTree()
    tree2.forEachLevelOrder { println(it.value) }


    val tree3 = makeBeverageTree()
    tree3.search("ginger ale")?.let {
        println("Found node: ${it.value}")
    }
    tree3.search("WKD Blue")?.let {
        println(it.value)
    } ?: println("Couldn't find WKD Blue")
    //Since it visits all nodes, if there
    //are multiple matches, the last match wins.
    //output:
    //Found node: ginger ale
    //Couldn't find WKD Blue

}

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)
    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)
    return tree
}