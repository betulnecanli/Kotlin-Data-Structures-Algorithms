/*
Longest Palindromic Subsequence:
The longestPalindromicSubsequence function calculates the length of the longest palindromic subsequence 
in a given string using a 2D array to store intermediate results.
Minimum Deletions in a String to Make it a Palindrome:
The minDeletionsToMakePalindrome function uses the result of the Longest Palindromic Subsequence approach to find 
the minimum deletions needed to make the string a palindrome.
*/

//1. Longest Palindromic Subsequence
fun longestPalindromicSubsequence(s: String): Int {
    val n = s.length

    // Create a 2D array to store the length of the longest palindromic subsequence
    val dp = Array(n) { IntArray(n) }

    // Initialize the diagonal elements with 1 (each character is a palindromic subsequence of length 1)
    for (i in 0 until n) {
        dp[i][i] = 1
    }

    // Populate the array using the Palindromic Subsequence approach
    for (len in 2..n) {
        for (i in 0 until n - len + 1) {
            val j = i + len - 1

            if (s[i] == s[j] && len == 2) {
                dp[i][j] = 2
            } else if (s[i] == s[j]) {
                dp[i][j] = dp[i + 1][j - 1] + 2
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i + 1][j])
            }
        }
    }

    return dp[0][n - 1]
}

fun main() {
    // Example usage
    val s = "bbbab"

    val result = longestPalindromicSubsequence(s)
    println("Length of the Longest Palindromic Subsequence: $result")
}


//2. Minimum Deletions in a String to Make it a Palindrome
fun minDeletionsToMakePalindrome(s: String): Int {
    val n = s.length

    // Use the Longest Palindromic Subsequence approach to find the length of the LPS
    val lpsLength = longestPalindromicSubsequence(s)

    // The minimum deletions needed is the difference between the string length and the LPS length
    return n - lpsLength
}

fun main() {
    // Example usage
    val s = "abca"

    val result = minDeletionsToMakePalindrome(s)
    println("Minimum Deletions to Make the String a Palindrome: $result")
}
