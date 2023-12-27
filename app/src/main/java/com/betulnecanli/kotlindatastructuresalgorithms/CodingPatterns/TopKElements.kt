/*
The "Top 'K' Elements" coding pattern is often used to efficiently find the K smallest or largest elements in a collection.
*/

//1. ‘K’ Closest Points to the Origin
import java.util.PriorityQueue

data class Point(val x: Int, val y: Int)

fun kClosest(points: Array<Point>, k: Int): Array<Point> {
    val result = mutableListOf<Point>()

    // Use a max heap to keep track of the 'K' closest points
    val maxHeap = PriorityQueue<Point>(compareByDescending { it.x * it.x + it.y * it.y })

    for (point in points) {
        maxHeap.offer(point)

        if (maxHeap.size > k) {
            maxHeap.poll()
        }
    }

    // Convert the max heap to an array
    while (maxHeap.isNotEmpty()) {
        result.add(maxHeap.poll())
    }

    return result.toTypedArray()
}

fun main() {
    val points = arrayOf(Point(1, 3), Point(3, 4), Point(2, -1), Point(4, 6))
    val k = 2

    val result = kClosest(points, k)
    println("K Closest Points to the Origin:")
    result.forEach { println("(${it.x}, ${it.y})") }
}

//2. Maximum Distinct Elements
import java.util.PriorityQueue
import java.util.HashMap

fun findMaximumDistinctElements(nums: IntArray, k: Int): Int {
    val frequencyMap = HashMap<Int, Int>()

    // Count the frequency of each number
    for (num in nums) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    // Use a min heap to keep track of the least frequent numbers
    val minHeap = PriorityQueue<Int>(compareBy { frequencyMap[it] })

    // Add numbers to the min heap
    for ((num, frequency) in frequencyMap) {
        if (frequency == 1) {
            // If a number has a frequency of 1, it's already a distinct element
            minHeap.offer(num)
        } else {
            // If a number has a frequency greater than 1, add it to the min heap
            // based on its frequency
            minHeap.offer(num)
            frequencyMap[num] = frequency - 1
        }

        // Remove the least frequent number if the heap size exceeds 'k'
        if (minHeap.size > k) {
            frequencyMap[minHeap.poll()] = 0
        }
    }

    // The size of the min heap represents the maximum distinct elements
    return minHeap.size
}

fun main() {
    val nums = intArrayOf(4, 3, 1, 1, 3, 3, 2, 4, 4)
    val k = 3

    val result = findMaximumDistinctElements(nums, k)
    println("Maximum Distinct Elements: $result")
}
/*
K’ Closest Points to the Origin:
The kClosest function finds the K closest points to the origin using a max heap. 
The max heap is used to efficiently keep track of the K closest points, 
and it prioritizes points based on their distance from the origin.
Maximum Distinct Elements:
The findMaximumDistinctElements function finds the maximum number of distinct elements in an array 
after removing at most 'k' elements. It uses a min heap to efficiently keep track of the least frequent numbers.
*/
