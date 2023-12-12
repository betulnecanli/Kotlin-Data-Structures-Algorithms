/*
Use this technique to solve problems that follow the Fibonacci numbers sequence, 
i.e., every subsequent number is calculated from the last few numbers.
*/

//1. Staircase
fun countWaysToClimbStairs(n: Int): Int {
    if (n <= 1) {
        return 1
    }

    var first = 1
    var second = 1

    for (i in 2..n) {
        val current = first + second
        first = second
        second = current
    }

    return second
}

fun main() {
    // Example usage
    val n = 4

    val ways = countWaysToClimbStairs(n)
    println("Number of ways to climb $n stairs: $ways")
}


//2. House Thief
fun maxStolenValue(houses: IntArray): Int {
    val n = houses.size

    if (n == 0) {
        return 0
    }

    if (n == 1) {
        return houses[0]
    }

    var first = houses[0]
    var second = maxOf(houses[0], houses[1])

    for (i in 2 until n) {
        val current = maxOf(first + houses[i], second)
        first = second
        second = current
    }

    return second
}

fun main() {
    // Example usage
    val houses = intArrayOf(6, 7, 1, 30, 8, 2, 4)

    val maxStolenValue = maxStolenValue(houses)
    println("Maximum stolen value: $maxStolenValue")
}


/*
Staircase:
The countWaysToClimbStairs function calculates the number of ways to climb a staircase with n steps. 
It uses two variables to represent the previous two Fibonacci numbers, 
iterating through the steps to calculate the current number of ways.
House Thief:
The maxStolenValue function calculates the maximum value that can be stolen from a row of houses, 
where no two adjacent houses can be robbed. It uses two variables to represent the maximum stolen values for the previous two houses, 
iterating through the houses to calculate the current maximum stolen value.
*/
