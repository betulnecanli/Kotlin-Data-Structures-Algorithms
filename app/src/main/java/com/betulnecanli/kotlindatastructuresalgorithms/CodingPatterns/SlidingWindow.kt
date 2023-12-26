/*
Sliding window is a technique used for efficiently processing arrays or lists by maintaining a "window" of elements as 
you iterate through the data. 
This can be particularly useful for problems where you need to find a subarray, 
substring, or some other contiguous segment of the data that satisfies a certain condition.
*/
// "Find the maximum sum of a subarray of a fixed size K."

fun maxSumSubarray(arr: IntArray, k: Int): Int {
    var windowSum = 0
    var maxSum = 0

    // Calculate the initial sum of the first window of size K
    for (i in 0 until k) {
        windowSum += arr[i]
    }

    // Iterate through the array, moving the window by one element at a time
    for (i in k until arr.size) {
        // Add the current element to the window sum and subtract the first element of the previous window
        windowSum = windowSum + arr[i] - arr[i - k]

        // Update the maximum sum if the current window sum is greater
        maxSum = maxOf(maxSum, windowSum)
    }

    return maxSum
}


fun main() {
    val arr = intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20)
    val k = 3
    val result = maxSumSubarray(arr, k)
    println("Maximum sum of a subarray of size $k is: $result")
}


/*
The "Fruits into Baskets" problem is a classic sliding window problem where you are given an array of fruits,
and you need to find the length of the longest subarray with at most two distinct fruit types. 
Here's a Kotlin implementation using the sliding window pattern:
*/

fun totalFruit(tree: IntArray): Int {
    var maxFruits = 0
    var fruitCount = 0
    var left = 0
    val fruitFrequency = mutableMapOf<Int, Int>()

    for (right in tree.indices) {
        // Add the current fruit to the frequency map
        fruitFrequency[tree[right]] = fruitFrequency.getOrDefault(tree[right], 0) + 1

        // Increment fruit count
        fruitCount++

        // Adjust the window by removing fruits until only two distinct fruits are in the basket
        while (fruitFrequency.size > 2) {
            fruitFrequency[tree[left]] = fruitFrequency[tree[left]]!! - 1
            if (fruitFrequency[tree[left]] == 0) {
                fruitFrequency.remove(tree[left])
            }
            left++
            fruitCount--
        }

        // Update the maximum number of fruits
        maxFruits = maxOf(maxFruits, fruitCount)
    }

    return maxFruits
}

fun main() {
    val tree = intArrayOf(1, 2, 1, 3, 4, 3, 5, 1, 2)
    val result = totalFruit(tree)
    println("The length of the longest subarray with at most two distinct fruits is: $result")
}
/*
In this example, the totalFruit function takes an array tree representing different types of fruits.
The goal is to find the length of the longest subarray with at most two distinct fruit types. 
The function uses a sliding window approach to keep track of the frequency of fruits in the basket.

The fruitFrequency map is used to store the count of each fruit type in the current window.
The left pointer is adjusted to maintain at most two distinct fruit types in the basket.
The fruitCount variable keeps track of the length of the current subarray.
*/
