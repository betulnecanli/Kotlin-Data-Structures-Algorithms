/*
This pattern is particularly useful when you need to modify the existing linked list in-place without using additional memory. 
It has applications in solving problems related to reversing the entire linked list, 
reversing sub-lists, or rotating a linked list.
*/


/*

Usage: This technique describes an efficient way to reverse the links between a set of nodes of a LinkedList. 
Often, the constraint is that we need to do this in-place, i.e., using the existing node objects and without using extra memory.

*/

//1. Reverse every K-element Sub-list
/*
he reverseKGroup function reverses every K-element sub-list in a linked list using the "In-place Reversal of a LinkedList" pattern. 
It breaks the list into K-node sub-lists, reverses each sub-list, and connects them back together.
*/
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k <= 1) {
        return head
    }

    var current = head
    var prevTail: ListNode? = null

    while (current != null) {
        val sublistHead = current
        var sublistTail: ListNode? = null
        var i = 0

        // Traverse k nodes in the sublist
        while (i < k && current != null) {
            val next = current.next
            current.next = sublistTail
            sublistTail = current
            current = next
            i++
        }

        if (i == k) {
            // Connect the reversed sublist to the previous tail or the head if it's the first sublist
            if (prevTail != null) {
                prevTail.next = sublistTail
            } else {
                head = sublistTail
            }

            // Connect the end of the sublist to the remaining nodes
            sublistHead.next = current

            // Update the previous tail for the next iteration
            prevTail = sublistHead
        } else {
            // If there are fewer than k nodes left, reverse the sublist again to revert the changes
            current = sublistTail
            while (current != null) {
                val next = current.next
                current.next = sublistHead
                sublistHead = current
                current = next
            }

            // Connect the reversed sublist to the previous tail or the head if it's the first sublist
            if (prevTail != null) {
                prevTail.next = sublistHead
            } else {
                head = sublistHead
            }
        }
    }

    return head
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    val k = 2
    val reversedHead = reverseKGroup(head, k)
    printList(reversedHead)
}

//2. Rotate a LinkedList
/*
The rotateRight function rotates a linked list to the right by K positions using the "In-place Reversal of a LinkedList" pattern.
It calculates the length of the list, finds the new tail and head, and adjusts the pointers accordingly.
*/
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 0) {
        return head
    }

    var length = 1
    var tail = head

    // Find the length of the linked list and the tail node
    while (tail?.next != null) {
        tail = tail.next
        length++
    }

    // Adjust k to avoid unnecessary rotations
    val rotations = k % length
    if (rotations == 0) {
        return head
    }

    var newTail = head
    for (i in 0 until length - rotations - 1) {
        newTail = newTail?.next
    }

    val newHead = newTail?.next
    newTail?.next = null
    tail?.next = head

    return newHead
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    val k = 2
    val rotatedHead = rotateRight(head, k)
    printList(rotatedHead)
}
