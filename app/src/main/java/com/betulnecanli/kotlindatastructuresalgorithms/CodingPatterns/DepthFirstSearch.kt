// The Depth-First Search (DFS) coding pattern is used for exploring or 
//traversing a data structure by going as deep as possible before backtracking.
/*
Usage: This technique is used to solve problems involving traversing trees or graphs in a depth-first search manner.
*/
//1. Path With Given Sequence
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun hasPathWithSequence(root: TreeNode?, sequence: List<Int>): Boolean {
    if (root == null) {
        return sequence.isEmpty()
    }

    return dfsPathWithSequence(root, sequence, 0)
}

fun dfsPathWithSequence(node: TreeNode?, sequence: List<Int>, index: Int): Boolean {
    if (node == null) {
        return false
    }

    if (index >= sequence.size || node.`val` != sequence[index]) {
        return false
    }

    if (node.left == null && node.right == null && index == sequence.size - 1) {
        return true
    }

    return (
        dfsPathWithSequence(node.left, sequence, index + 1) ||
        dfsPathWithSequence(node.right, sequence, index + 1)
    )
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(7)
    root.right = TreeNode(9)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right?.left = TreeNode(2)
    root.right?.right = TreeNode(7)

    val sequence = listOf(1, 9, 7)
    val result = hasPathWithSequence(root, sequence)
    println("Has Path with Sequence $sequence: $result")
}


//2. Count Paths for a Sum
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun countPathsForSum(root: TreeNode?, targetSum: Int): Int {
    return if (root == null) 0 else dfsCountPaths(root, targetSum) +
            countPathsForSum(root.left, targetSum) +
            countPathsForSum(root.right, targetSum)
}

fun dfsCountPaths(node: TreeNode?, remainingSum: Int): Int {
    if (node == null) {
        return 0
    }

    var pathCount = 0

    if (node.`val` == remainingSum) {
        pathCount++
    }

    pathCount += dfsCountPaths(node.left, remainingSum - node.`val`)
    pathCount += dfsCountPaths(node.right, remainingSum - node.`val`)

    return pathCount
}

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(1)
    root.right?.right = TreeNode(11)
    root.left?.left?.left = TreeNode(3)
    root.left?.left?.right = TreeNode(-2)
    root.left?.right?.right = TreeNode(2)

    val targetSum = 8
    val result = countPathsForSum(root, targetSum)
    println("Number of Paths for Sum $targetSum: $result")
}

/*
Path With Given Sequence:
The hasPathWithSequence function checks whether there exists a root-to-leaf path in the binary tree that matches 
the given sequence using the DFS pattern.
Count Paths for a Sum:
The countPathsForSum function counts the number of paths in the binary tree where the sum of node values equals 
the target sum using the DFS pattern.
*/
