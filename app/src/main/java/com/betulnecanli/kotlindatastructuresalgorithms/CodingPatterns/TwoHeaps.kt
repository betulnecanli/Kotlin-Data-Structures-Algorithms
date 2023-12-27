// The "Two Heaps" coding pattern involves using two heaps (usually a max heap and a min heap) to efficiently solve problems  
//where you need to find the median or maintain order statistics in a stream of numbers. 
/*
Usage: In many problems, we are given a set of elements that can be divided into two parts.
We are interested in knowing the smallest element in one part and the biggest element in the other part. 
As the name suggests, this technique uses a Min-Heap to find the smallest element and a Max-Heap to find the biggest element.
*/
//1. Find the Median of a Number Stream
import java.util.PriorityQueue

class MedianFinder {
    private val maxHeap = PriorityQueue<Int>(kotlin.Comparator.reverseOrder())
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        // Balance the heaps
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.offer(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.offer(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            maxHeap.peek().toDouble()
        }
    }
}

fun main() {
    val medianFinder = MedianFinder()

    medianFinder.addNum(1)
    println("Median: ${medianFinder.findMedian()}") // Output: 1.0

    medianFinder.addNum(2)
    println("Median: ${medianFinder.findMedian()}") // Output: 1.5

    medianFinder.addNum(3)
    println("Median: ${medianFinder.findMedian()}") // Output: 2.0
}


//2. Next Interval for a Sum
import java.util.PriorityQueue

data class Interval(val start: Int, val end: Int)

fun findNextInterval(intervals: List<Interval>, targets: List<Int>): List<Interval?> {
    val result = mutableListOf<Interval?>()
    val maxHeap = PriorityQueue<Interval>(compareBy { it.start })

    for ((i, interval) in intervals.withIndex()) {
        maxHeap.offer(interval)
    }

    for (target in targets) {
        var found = false

        while (maxHeap.isNotEmpty()) {
            val interval = maxHeap.poll()

            if (interval.start >= target) {
                result.add(interval)
                found = true
                break
            }
        }

        if (!found) {
            result.add(null)
        }

        maxHeap.addAll(intervals.subList(i + 1, intervals.size))
    }

    return result
}

fun main() {
    val intervals = listOf(
        Interval(1, 3),
        Interval(2, 4),
        Interval(5, 7)
    )

    val targets = listOf(2, 4, 8)

    val result = findNextInterval(intervals, targets)
    println("Next Intervals: ${result.joinToString(", ")}")
}

/*
Find the Median of a Number Stream:
The MedianFinder class uses two heaps to maintain the balance of numbers and efficiently find the median of a stream of numbers.
The max heap stores the smaller half of the numbers, and the min heap stores the larger half.
Next Interval for a Sum:
The findNextInterval function uses a max heap to efficiently find the next interval for a given target sum. 
It iterates through the intervals and maintains a max heap of intervals starting before the target.

*/
