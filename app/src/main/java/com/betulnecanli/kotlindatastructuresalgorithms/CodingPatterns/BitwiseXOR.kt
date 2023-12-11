/*
This technique uses the XOR operator to manipulate bits to solve problems.
*/
//1. Two Single Numbers
fun findSingleNumbers(nums: IntArray): IntArray {
    // Step 1: Find the XOR of all numbers
    var xorResult = 0
    for (num in nums) {
        xorResult = xorResult xor num
    }

    // Step 2: Find the rightmost set bit in the XOR result
    val rightmostSetBit = xorResult and -xorResult

    // Step 3: Use the rightmost set bit to separate the numbers into two groups
    var group1 = 0
    var group2 = 0

    for (num in nums) {
        if ((num and rightmostSetBit) != 0) {
            group1 = group1 xor num
        } else {
            group2 = group2 xor num
        }
    }

    return intArrayOf(group1, group2)
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 6, 5)

    val result = findSingleNumbers(nums)
    println("Two Single Numbers: ${result.joinToString(", ")}")
}

//2. Flip and Invert an Image
fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    val numRows = A.size
    val numCols = A[0].size

    for (row in A) {
        // Step 1: Flip the row using XOR
        var left = 0
        var right = row.size - 1

        while (left <= right) {
            val temp = row[left] xor 1
            row[left] = row[right] xor 1
            row[right] = temp

            left++
            right--
        }
    }

    return A
}

fun main() {
    val image = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0)
    )

    val result = flipAndInvertImage(image)
    println("Flipped and Inverted Image:")
    for (row in result) {
        println(row.joinToString(" "))
    }
}
