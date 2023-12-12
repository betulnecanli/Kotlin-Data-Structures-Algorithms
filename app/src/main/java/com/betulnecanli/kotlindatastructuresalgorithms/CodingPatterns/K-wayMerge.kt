/*
The "K-way Merge" coding pattern is commonly used to merge K sorted lists or arrays efficiently.
*/
//1. Kth Smallest Number in M Sorted Lists
import java.util.PriorityQueue

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val minHeap = PriorityQueue<ListNode?>(compareBy { it?.`val` })

    // Add the heads of all lists to the min heap
    for (list in lists) {
        if (list != null) {
            minHeap.offer(list)
        }
    }

    var dummy = ListNode(0)
    var current: ListNode? = dummy

    // Merge lists by repeatedly extracting the smallest element from the min heap
    while (minHeap.isNotEmpty()) {
        val minNode = minHeap.poll()
        current?.next = minNode
        current = current?.next

        if (minNode?.next != null) {
            minHeap.offer(minNode.next)
        }
    }

    return dummy.next
}

fun kthSmallestInLists(lists: Array<ListNode?>, k: Int): Int {
    val mergedList = mergeKLists(lists)
    var result = -1
    var count = 0
    var current: ListNode? = mergedList

    // Traverse the merged list to find the kth smallest element
    while (current != null) {
        count++
        if (count == k) {
            result = current.`val`
            break
        }
        current = current.next
    }

    return result
}

fun main() {
    // Example usage
    val list1 = ListNode(2)
    list1.next = ListNode(6)
    list1.next?.next = ListNode(8)

    val list2 = ListNode(3)
    list2.next = ListNode(6)
    list2.next?.next = ListNode(7)

    val list3 = ListNode(1)
    list3.next = ListNode(3)
    list3.next?.next = ListNode(4)

    val lists = arrayOf(list1, list2, list3)
    val k = 5

    val result = kthSmallestInLists(lists, k)
    println("Kth Smallest Number in M Sorted Lists: $result")
}

//2. Kth Smallest Number in a Sorted Matrix
import java.util.PriorityQueue

fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val minHeap = PriorityQueue<Pair<Int, Pair<Int, Int>>>(compareBy { it.first })

    // Add the first element of each row to the min heap
    for (i in matrix.indices) {
        minHeap.offer(Pair(matrix[i][0], Pair(i, 0)))
    }

    var result = -1

    // Extract the smallest element 'k' times
    repeat(k) {
        val current = minHeap.poll()
        result = current.first
        val rowIndex = current.second.first
        val colIndex = current.second.second

        // If there are more elements in the current row, add the next element to the min heap
        if (colIndex + 1 < matrix[rowIndex].size) {
            minHeap.offer(Pair(matrix[rowIndex][colIndex + 1], Pair(rowIndex, colIndex + 1)))
        }
    }

    return result
}

fun main() {
    // Example usage
    val matrix = arrayOf(
        intArrayOf(1, 5, 9),
        intArrayOf(10, 11, 13),
        intArrayOf(12, 13, 15)
    )

    val k = 8

    val result = kthSmallest(matrix, k)
    println("Kth Smallest Number in a Sorted Matrix: $result")
}

/*
Kth Smallest Number in M Sorted Lists:
The mergeKLists function merges K sorted lists using a min heap and returns the head of the merged list. 
The kthSmallestInLists function then finds the kth smallest number in the merged list.
Kth Smallest Number in a Sorted Matrix:
The kthSmallest function finds the kth smallest number in a sorted matrix using a min heap. 
It repeatedly extracts the smallest element and adds the next element from the same row if available.
*/
