package com.betulnecanli.kotlindatastructuresalgorithms.Complexity.SpaceComplexity

fun main(){
    //The time complexity of an algorithm isn't the only performance metric against which
    //algorithms are ranked. Another important metric is its space complexity, which is a
    //measure of the amount of memory it uses.
    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    printSorted(numbers)
    printSortedOptimized(numbers)

}

//Since numbers.sorted() produces a new list with the same size of numbers, the
//space complexity of printSorted is O(n). While this function is simple and elegant,
//there may be some situations in which you want to allocate as little memory as
//possible.
fun printSorted(numbers: List<Int>) {
    val sorted = numbers.sorted()
    for (element in sorted) {
        println(element)
    }
}

//You could rewrite the above function like this:
fun printSortedOptimized(numbers: List<Int>) {
    // 1
    if (numbers.isEmpty()) return
    // 2
    var currentCount = 0
    var minValue = Int.MIN_VALUE
    // 3
    for (value in numbers) {
        if (value == minValue) {
            println(value)
            currentCount += 1
        }
    }
    while (currentCount < numbers.size) {
        // 4
        var currentValue = numbers.max()!!
        for (value in numbers) {
            if (value < currentValue && value > minValue) {
                currentValue = value
            }
        }
        // 5
        for (value in numbers) {
            if (value == currentValue) {
                println(value)
                currentCount += 1
            }
        }
        // 6
        minValue = currentValue
    }
}

//1. Check for the case if the list is empty. If it is, there’s nothing to print.
//2. currentCount keeps track of the number of print statements made. minValue
//stores the last printed value.
//3. The algorithm begins by printing all values matching the minValue and updates
//the currentCount according to the number of print statements made.
//4. Using the while loop, the algorithm finds the lowest value bigger than minValue
//and stores it in currentValue.
//5. The algorithm then prints all values of currentValue inside the array while
//updating currentCount.
//6. minValue is set to currentValue, so the next iteration will try to find the next
//minimum value.

//The above algorithm only allocates memory for a few variables. Since the amount of
//memory allocated is constant and does not depend on the size of the list, the space
//complexity is O(1).