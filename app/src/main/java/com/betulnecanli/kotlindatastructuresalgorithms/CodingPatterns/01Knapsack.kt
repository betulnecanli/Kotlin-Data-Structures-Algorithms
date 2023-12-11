/*
This technique is used to solve optimization problems. 
Use this technique to select elements that give maximum profit from a given set with a limitation on capacity 
and that each element can only be picked once.
*/

//1. Equal Subset Sum Partition
fun canPartition(nums: IntArray): Boolean {
    val totalSum = nums.sum()

    // If the total sum is odd, equal partition is not possible
    if (totalSum % 2 != 0) {
        return false
    }

    val targetSum = totalSum / 2
    val n = nums.size

    // Create a 2D array to store the intermediate results of the subproblems
    val dp = Array(n + 1) { BooleanArray(targetSum + 1) }

    // Initialization: An empty subset can always achieve a sum of 0
    for (i in 0..n) {
        dp[i][0] = true
    }

    // Populate the 2D array using the 0/1 Knapsack approach
    for (i in 1..n) {
        for (j in 1..targetSum) {
            if (j >= nums[i - 1]) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }

    return dp[n][targetSum]
}

fun main() {
    // Example usage
    val nums = intArrayOf(1, 5, 11, 5)

    val result = canPartition(nums)
    println("Can the array be partitioned into two equal subsets? $result")
}

//2. Minimum Subset Sum Difference in a Sorted Matrix
fun minSubsetSumDifference(matrix: Array<IntArray>): Int {
    val totalSum = matrix.flatten().sum()
    val targetSum = totalSum / 2

    val numRows = matrix.size
    val numCols = matrix[0].size

    // Create a 2D array to store the intermediate results of the subproblems
    val dp = Array(numRows + 1) { IntArray(targetSum + 1) }

    // Populate the 2D array using the 0/1 Knapsack approach
    for (i in 1..numRows) {
        for (j in 1..targetSum) {
            if (j >= matrix[i - 1][numCols - 1]) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - matrix[i - 1][numCols - 1]] + matrix[i - 1][numCols - 1])
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }

    // The minimum subset sum difference is equal to the total sum minus twice the maximum subset sum
    val maxSubsetSum = dp[numRows][targetSum]
    val minSubsetSumDifference = totalSum - 2 * maxSubsetSum

    return minSubsetSumDifference
}

fun main() {
    // Example usage
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    val result = minSubsetSumDifference(matrix)
    println("Minimum Subset Sum Difference in the Sorted Matrix: $result")
}
/*
Equal Subset Sum Partition:
The canPartition function determines whether it's possible to partition an array 
into two subsets with equal sums using the 0/1 Knapsack approach. It uses a 2D array to store the intermediate results of subproblems.
Minimum Subset Sum Difference in a Sorted Matrix:
The minSubsetSumDifference function calculates the minimum subset sum difference in a sorted matrix using the 0/1 Knapsack approach.
It aims to partition the matrix into two subsets with sums as close as possible. 
The minimum subset sum difference is then computed based on the total sum and the maximum subset sum.
*/
