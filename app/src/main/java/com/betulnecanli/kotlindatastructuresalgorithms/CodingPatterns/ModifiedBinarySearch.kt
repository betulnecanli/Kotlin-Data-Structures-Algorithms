/*
Use this technique to search a sorted set of elements efficiently.
The "Modified Binary Search" coding pattern is a variation of the standard binary search,
often used to find specific elements or conditions in a sorted array that doesn't necessarily have a straightforward match.
*/

//1. Ceiling of a Number
fun searchCeilingOfNumber(arr: IntArray, key: Int): Int {
    if (key > arr.last()) {
        return -1 // No ceiling exists as the key is greater than the largest element
    }

    var start = 0
    var end = arr.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (arr[mid] == key) {
            return mid // Found an exact match
        }

        if (key < arr[mid]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return start // 'start' is the index of the ceiling of the key
}

fun main() {
    val arr = intArrayOf(4, 6, 10)
    val key = 6

    val ceilingIndex = searchCeilingOfNumber(arr, key)
    val ceiling = if (ceilingIndex != -1) arr[ceilingIndex] else -1

    println("Ceiling of $key: $ceiling")
}

//2. Bitonic Array Maximum
fun findBitonicArrayMax(arr: IntArray): Int {
    var start = 0
    var end = arr.size - 1

    while (start < end) {
        val mid = start + (end - start) / 2

        if (arr[mid] > arr[mid + 1]) {
            // We are in the descending part of the bitonic array
            end = mid
        } else {
            // We are in the ascending part of the bitonic array
            start = mid + 1
        }
    }

    // 'start' is the index of the maximum element in the bitonic array
    return arr[start]
}

fun main() {
    val arr = intArrayOf(1, 3, 8, 12, 4, 2)
    val maxElement = findBitonicArrayMax(arr)

    println("Maximum Element in the Bitonic Array: $maxElement")
}

/*
Ceiling of a Number:
The searchCeilingOfNumber function finds the smallest number in the array that is greater than or equal to the given key. 
If the key is greater than the largest element in the array, it returns -1.
Bitonic Array Maximum:
The findBitonicArrayMax function finds the maximum element in a bitonic array. 
A bitonic array is one that starts monotonically increasing and then monotonically decreases.

*/
