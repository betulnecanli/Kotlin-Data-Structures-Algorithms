/*
The Breadth-First Search (BFS) coding pattern is a popular technique for traversing or processing data structures 
in a level-by-level manner. 
It is commonly used with trees, graphs, and other structures where you want to visit all the neighbors at the current
depth before moving on to the next level.
*/
//1. Binary Tree Level Order Traversal
import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun levelOrderTraversal(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if (root == null) {
        return result
    }

    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()

        for (i in 0 until levelSize) {
            val currentNode = queue.poll()
            currentLevel.add(currentNode.`val`)

            currentNode.left?.let { queue.offer(it) }
            currentNode.right?.let { queue.offer(it) }
        }

        result.add(currentLevel)
    }

    return result
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val result = levelOrderTraversal(root)
    println("Level Order Traversal: $result")
}

//2. Minimum Depth of a Binary Tree
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    var depth = 1

    while (queue.isNotEmpty()) {
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val currentNode = queue.poll()

            if (currentNode.left == null && currentNode.right == null) {
                return depth
            }

            currentNode.left?.let { queue.offer(it) }
            currentNode.right?.let { queue.offer(it) }
        }

        depth++
    }

    return depth
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val result = minDepth(root)
    println("Minimum Depth of the Binary Tree: $result")
}
//3. Connect Level Order Siblings
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var next: TreeNode? = null
}

fun connectLevelOrderSiblings(root: TreeNode?) {
    if (root == null) {
        return
    }

    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        var prevNode: TreeNode? = null

        for (i in 0 until levelSize) {
            val currentNode = queue.poll()

            if (prevNode != null) {
                prevNode.next = currentNode
            }

            prevNode = currentNode

            currentNode.left?.let { queue.offer(it) }
            currentNode.right?.let { queue.offer(it) }
        }
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(7)

    connectLevelOrderSiblings(root)

    // The 'next' pointers are now connected level by level
    println("Next pointers connected: ${root.next?.`val`}, ${root.left?.next?.`val`}, ${root.right?.next?.`val`}")
}
/*
Binary Tree Level Order Traversal:
The levelOrderTraversal function performs a BFS traversal of a binary tree, processing nodes level by level. 
It uses a queue to enqueue and dequeue nodes at each level.
Minimum Depth of a Binary Tree:
The minDepth function calculates the minimum depth of a binary tree using BFS. 
It traverses the tree level by level, and when it encounters the first leaf node, it returns the depth.
Connect Level Order Siblings:
The connectLevelOrderSiblings function connects the 'next' pointers of nodes at the same level in a binary tree.
It uses BFS to traverse the tree level by level and connects the 'next' pointers accordingly.
*/
