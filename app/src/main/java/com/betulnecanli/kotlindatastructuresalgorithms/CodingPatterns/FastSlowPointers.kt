/*
 The Fast and Slow Pointers technique involves using two pointers to traverse a sequence at different speeds, 
 often leading to efficient solutions for problems involving cycle detection, finding middle elements, or other related tasks. 
 Let's explore three problems: "Middle of the LinkedList," "Happy Number," and "Cycle in a Circular Array," 
 providing Kotlin implementations for each.
*/

//1. Middle of the LinkedList
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}

fun main() {
    // Example of creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    val result = middleNode(head)
    println("Middle Node: ${result?.`val`}")
}

//2. Happy Number
fun isHappy(n: Int): Boolean {
    var slow = n
    var fast = n

    do {
        slow = squareSum(slow)
        fast = squareSum(squareSum(fast))
    } while (slow != fast)

    return slow == 1
}

fun squareSum(n: Int): Int {
    var sum = 0
    var num = n

    while (num > 0) {
        val digit = num % 10
        sum += digit * digit
        num /= 10
    }

    return sum
}

fun main() {
    val number = 19
    val result = isHappy(number)
    println("$number is a Happy Number: $result")
}

//3. Cycle in a Circular Array
fun circularArrayLoop(nums: IntArray): Boolean {
    val n = nums.size

    fun getNextIndex(currentIndex: Int): Int {
        val nextIndex = (currentIndex + nums[currentIndex]) % n
        return if (nextIndex >= 0) nextIndex else n + nextIndex
    }

    for (i in 0 until n) {
        var slow = i
        var fast = i

        var isForward = nums[i] >= 0

        do {
            slow = getNextIndex(slow)
            fast = getNextIndex(getNextIndex(fast))

            if (nums[fast] * nums[i] < 0) {
                break // Direction changed, no cycle possible
            }

        } while (slow != fast)

        if (slow == fast) {
            return true
        }
    }

    return false
}

fun main() {
    val nums = intArrayOf(2, -1, 1, 2, 2)
    val result = circularArrayLoop(nums)
    println("Contains a Circular Array Loop: $result")
}
