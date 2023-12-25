/*
The "Longest Common Substring" coding pattern is often used to solve problems where you need to 
find the longest common substring between two given strings.
*/
//1. Maximum Sum Increasing Subsequence
fun maxSumIncreasingSubsequence(nums: IntArray): Int {
    val n = nums.size

    // Create an array to store the maximum sum increasing subsequence ending at each index
    val dp = IntArray(n)

    // Initialize each element with its own value
    for (i in 0 until n) {
        dp[i] = nums[i]
    }

    // Populate the array using the Longest Common Substring approach
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
                dp[i] = dp[j] + nums[i]
            }
        }
    }

    // Find the maximum sum in the dp array
    return dp.maxOrNull() ?: 0
}

fun main() {
    // Example usage
    val nums = intArrayOf(4, 6, 1, 3, 8, 4, 6)

    val result = maxSumIncreasingSubsequence(nums)
    println("Maximum Sum Increasing Subsequence: $result")
}


//2. Edit Distance
fun minEditDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length

    // Create a 2D array to store the minimum edit distance between prefixes of the two words
    val dp = Array(m + 1) { IntArray(n + 1) }

    // Initialize the first row and column with values 0 to m and 0 to n respectively
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0) {
                dp[i][j] = j
            } else if (j == 0) {
                dp[i][j] = i
            } else if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = 1 + minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
            }
        }
    }

    return dp[m][n]
}

fun main() {
    // Example usage
    val word1 = "horse"
    val word2 = "ros"

    val result = minEditDistance(word1, word2)
    println("Minimum Edit Distance: $result")
}

/*
Maximum Sum Increasing Subsequence:
The maxSumIncreasingSubsequence function calculates the maximum sum increasing subsequence for 
a given array of integers using a 1D array to store intermediate results.
Edit Distance:
The minEditDistance function calculates the minimum edit distance (the number of operations 
needed to convert one string into another) using a 2D array to store intermediate results.
*/
