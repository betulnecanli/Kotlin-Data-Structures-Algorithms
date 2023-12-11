/*
The Cyclic Sort pattern is used to solve problems where the goal is to sort an array of numbers in a specific range 
or find the missing or duplicate number in a range. Let's tackle a simple problem: 
"Find the Missing Number in a Consecutive Array." I'll provide a Kotlin implementation for it.

Usage: Use this technique to solve array problems where the input data lies within a fixed range.
*/
//1.Find the Missing Number in a Consecutive Array
fun findMissingNumber(nums: IntArray): Int {
    var i = 0

    while (i < nums.size) {
        if (nums[i] < nums.size && nums[i] != i) {
            // Swap the number to its correct position
            val temp = nums[i]
            nums[i] = nums[temp]
            nums[temp] = temp
        } else {
            i++
        }
    }

    // Find the first missing number
    for (j in nums.indices) {
        if (nums[j] != j) {
            return j
        }
    }

    // If no missing number found, return the next number in the sequence
    return nums.size
}

fun main() {
    val nums = intArrayOf(3, 0, 1)
    val missingNumber = findMissingNumber(nums)
    println("Missing Number: $missingNumber")
}


/*
In this example:

The findMissingNumber function takes an array of integers and finds the missing number in a consecutive array starting from 0.
We use the Cyclic Sort pattern to iterate through the array and swap numbers to their correct positions.
After the Cyclic Sort, we find the first index where the number is not equal to the index, and that is the missing number.
You can modify the nums array in the main function to test different scenarios. 
This problem demonstrates how Cyclic Sort can be applied to efficiently find a missing number in a consecutive array.

*/


//2.Find All Duplicate Numbers
fun findDuplicates(nums: IntArray): List<Int> {
    val duplicates = mutableListOf<Int>()

    var i = 0
    while (i < nums.size) {
        if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
            // Swap the number to its correct position
            val temp = nums[i]
            nums[i] = nums[temp - 1]
            nums[temp - 1] = temp
        } else {
            i++
        }
    }

    for (j in nums.indices) {
        if (nums[j] != j + 1) {
            duplicates.add(nums[j])
        }
    }

    return duplicates
}

fun main() {
    val nums = intArrayOf(4, 3, 2, 7, 8, 2, 1, 1)
    val duplicates = findDuplicates(nums)
    println("Duplicate Numbers: ${duplicates.joinToString(", ")}")
}


//3.Find the First K Missing Positive Numbers
fun findKMissingPositive(nums: IntArray, k: Int): List<Int> {
    val missingNumbers = mutableListOf<Int>()

    var i = 0
    var count = 0

    while (count < k) {
        if (nums[i] > 0 && nums[i] <= nums.size && nums[i] != nums[nums[i] - 1]) {
            // Swap the number to its correct position
            val temp = nums[i]
            nums[i] = nums[temp - 1]
            nums[temp - 1] = temp
        } else {
            i++
        }
        count++
    }

    var j = 0
    while (missingNumbers.size < k) {
        if (nums[j] != j + 1) {
            missingNumbers.add(j + 1)
        }
        j++
    }

    return missingNumbers
}

fun main() {
    val nums = intArrayOf(2, 3, 4, 7, 11)
    val k = 5
    val missingNumbers = findKMissingPositive(nums, k)
    println("First $k Missing Positive Numbers: ${missingNumbers.joinToString(", ")}")
}
/*
Find All Duplicate Numbers:
The findDuplicates function finds all duplicate numbers in an array using the Cyclic Sort pattern. 
After the Cyclic Sort, we iterate through the array and identify the duplicate numbers.
Find the First K Missing Positive Numbers:
The findKMissingPositive function finds the first K missing positive numbers in an array using the Cyclic Sort pattern. 
After the Cyclic Sort, we iterate through the array and identify the missing positive numbers until we find K of them.
*/
