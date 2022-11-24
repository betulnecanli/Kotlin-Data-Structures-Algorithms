package com.betulnecanli.kotlindatastructuresalgorithms.Complexity.TimeComplexity

fun main(){
//For brevity, programmers use a notation known as Big O notation to represent
//various magnitudes of time complexity.
    val list = mutableListOf<String>("a","b","c")
    checkFirst(list)
    printNames(list)
    multiplicationBoard(10)
    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    pseudoBinaryContains(66,numbers)

}

        //constant time
        /*The size of names does not affect the running time of this function. Whether names
         has 10 items or 10 million items, this function only checks the first element of the
        list*/
        //The Big O notation for constant time is O(1).
        //It’s one unit of time, regardless of the input. This time doesn’t need to be small,
        //though. The algorithm can still be slow, but it’s equally slow all of the time.
        fun checkFirst(names: List<String>){
        if(names.firstOrNull() != null){
            println(names.first())
        }
        else{
            println("no names")
        }
    }

        //linear time
        /*This function prints all the names in a String list. As the input list increases in size,
          the number of iterations is increased by the same amount.
          Linear time complexity is usually the easiest to understand. As the amount of data
          increases, the running time increases by the same amount. That’s why you have the
          straight linear graph illustrated above.*/
        //The Big O notation for linear time is O(n).
        fun printNames(names : List<String>){
            for(name in names){
                println(name)
            }
        }

        /*Note: What about a function that has two loops over all of the data and a calls
        six different O(1) methods? Is it O(2n + 6) ?
        Time complexity only gives a high-level shape of the performance. Loops that
        happen a set number of times are not part of the calculation. You’ll need to
        abstract everything and consider only the most important thing that affects
        performance. All constants are dropped in the final Big O notation. In other
        words, O(2n + 6) is surprisingly equal to O(n).
         */

        //quadratic time
        //More commonly referred to as n squared, this time complexity refers to an
        //algorithm that takes time proportional to the square of the input size.
        /*If the input is 10, it’ll print the full multiplication board of 10 × 10. That’s 100 print
        statements. If you increase the input size by one, it’ll print the product of 11
        numbers with 11 numbers, resulting in 121 print statements.
        Unlike the previous function, which operates in linear time, the n squared algorithm
        can quickly run out of control as the data size increases. Imagine printing the results
        for multiplicationBoard(100_000)!*/
        //The Big O notation for quadratic time is O(n^2).
        fun multiplicationBoard(size : Int){
            for(number in 1..size){
                print(" | ")
                for(otherNumber in 1..size){
                    print("$number x $otherNumber = ${number * otherNumber} |")
                }
                println()
            }
        }

        //logarithmic time
        //The algorithm first checks the middle value to see how it compares with the desired
        //value. If the middle value is bigger than the desired value, the algorithm won’t
        //bother looking at the values on the right half of the list; since the list is sorted,
        //values to the right of the middle value can only get bigger
        //Algorithms in this category are few but are extremely powerful in situations that
        //allow for it.
        // The Big O notation for logarithmic time complexity is O(log n).

        fun pseudoBinaryContains(value  : Int, numbers : List<Int> ) : Boolean{
            if(numbers.isEmpty()) return false
            val middleIndex  = numbers.size / 2

            if(value <= numbers[middleIndex]){
                for(index in 0..middleIndex){
                    if(numbers[index] == value){
                        return true
                    }
                }
            } else{
                for (index in middleIndex until numbers.size){
                    if(numbers[index] == value){
                        return true
                    }
                }
            }
            return false
        }

        //quasilinear time
        //The Big-O notation for quasilinear time complexity is O(n log n)
        // which is a multiplication of linear and logarithmic time.
        // So quasilinear fits between logarithmic and linear time.
        //The quasilinear time complexity shares a similar curve with quadratic time. The key
        //difference is that quasilinear complexity is more resilient to large data sets.