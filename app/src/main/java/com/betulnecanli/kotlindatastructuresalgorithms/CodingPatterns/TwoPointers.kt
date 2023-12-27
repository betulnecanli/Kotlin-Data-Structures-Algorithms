/*
The two-pointer technique is often used for problems that involve searching for a pair of elements, sorting, 
or finding a subarray with a specific property. Let's tackle three problems: 
"Squaring a Sorted Array," "Dutch National Flag Problem," and "Minimum Window Sort in a Matrix." 
I'll provide Kotlin implementations for each.
*/
//1. Squaring a Sorted Array
fun sortedSquares(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)
    var left = 0
    var right = n - 1
    var index = n - 1

    while (left <= right) {
        val leftSquare = nums[left] * nums[left]
        val rightSquare = nums[right] * nums[right]

        if (leftSquare > rightSquare) {
            result[index] = leftSquare
            left++
        } else {
            result[index] = rightSquare
            right--
        }

        index--
    }

    return result
}

fun main() {
    val nums = intArrayOf(-4, -1, 0, 3, 10)
    val result = sortedSquares(nums)
    println("Squared Sorted Array: ${result.joinToString(", ")}")
}

//2. Dutch National Flag Problem
fun sortColors(nums: IntArray) {
    var low = 0
    var high = nums.size - 1
    var i = 0

    while (i <= high) {
        when {
            nums[i] == 0 -> {
                swap(nums, i, low)
                i++
                low++
            }
            nums[i] == 2 -> {
                swap(nums, i, high)
                high--
            }
            else -> {
                i++
            }
        }
    }
}

fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

fun main() {
    val colors = intArrayOf(2, 0, 2, 1, 1, 0)
    sortColors(colors)
    println("Sorted Colors: ${colors.joinToString(", ")}")
}

//3. Minimum Window Sort
fun minWindowSort(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    // Find the left bound of the unsorted subarray
    while (left < nums.size - 1 && nums[left] <= nums[left + 1]) {
        left++
    }

    if (left == nums.size - 1) {
        return 0 // The array is already sorted
    }

    // Find the right bound of the unsorted subarray
    while (right > 0 && nums[right] >= nums[right - 1]) {
        right--
    }

    // Find the minimum and maximum values in the unsorted subarray
    var minVal = Int.MAX_VALUE
    var maxVal = Int.MIN_VALUE
    for (i in left..right) {
        minVal = minOf(minVal, nums[i])
        maxVal = maxOf(maxVal, nums[i])
    }

    // Expand the left bound to include elements smaller than minVal
    while (left > 0 && nums[left - 1] > minVal) {
        left--
    }

    // Expand the right bound to include elements greater than maxVal
    while (right < nums.size - 1 && nums[right + 1] < maxVal) {
        right++
    }

    return right - left + 1
}

fun main() {
    val nums = intArrayOf(1, 3, 5, 2, 6, 4, 8)
    val result = minWindowSort(nums)
    println("Minimum Window to Sort: $result")
}
