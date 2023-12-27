/*
Use this technique to select elements that give maximum profit from a given set with a limitation on capacity 
and that each element can be picked multiple times.
*/

//1. Rod Cutting
fun maxRodCuttingProfit(lengths: IntArray, prices: IntArray, rodLength: Int): Int {
    val n = lengths.size

    // Create a 1D array to store the maximum profit for each length
    val dp = IntArray(rodLength + 1)

    // Populate the array using the Unbounded Knapsack approach
    for (i in 1..rodLength) {
        for (j in 0 until n) {
            if (lengths[j] <= i) {
                dp[i] = maxOf(dp[i], dp[i - lengths[j]] + prices[j])
            }
        }
    }

    return dp[rodLength]
}

fun main() {
    // Example usage
    val lengths = intArrayOf(1, 2, 3, 4, 5)
    val prices = intArrayOf(2, 5, 9, 6, 8)
    val rodLength = 5

    val result = maxRodCuttingProfit(lengths, prices, rodLength)
    println("Maximum Rod Cutting Profit: $result")
}

//2. Coin Change
fun minCoinsToMakeChange(coins: IntArray, amount: Int): Int {
    val n = coins.size

    // Create a 1D array to store the minimum number of coins for each amount
    val dp = IntArray(amount + 1) { Int.MAX_VALUE }

    // Initialization: Zero coins needed to make change for amount 0
    dp[0] = 0

    // Populate the array using the Unbounded Knapsack approach
    for (i in 1..amount) {
        for (j in 0 until n) {
            if (coins[j] <= i && dp[i - coins[j]] != Int.MAX_VALUE) {
                dp[i] = minOf(dp[i], dp[i - coins[j]] + 1)
            }
        }
    }

    return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
}

fun main() {
    // Example usage
    val coins = intArrayOf(1, 2, 5)
    val amount = 11

    val result = minCoinsToMakeChange(coins, amount)
    println("Minimum Coins to Make Change: $result")
}


/*
Rod Cutting:
The maxRodCuttingProfit function calculates the maximum profit that can be obtained by cutting a rod of a given length into pieces 
of different lengths, each with its corresponding price.
It uses a 1D array to store the maximum profit for each possible rod length.
Coin Change:
The minCoinsToMakeChange function calculates the minimum number of coins needed to make change for a given amount using a set of coin 
denominations. It uses a 1D array to store the minimum number of coins for each possible amount.

*/
