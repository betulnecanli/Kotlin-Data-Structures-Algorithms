/*
Use this technique to find a linear ordering of elements that have dependencies on each other.
*/

//1. Tasks Scheduling
import java.util.*

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    // Create an adjacency list to represent the directed graph
    val graph = Array(numCourses) { mutableListOf<Int>() }
    val inDegrees = IntArray(numCourses)

    // Populate the adjacency list and in-degrees array
    for (edge in prerequisites) {
        graph[edge[1]].add(edge[0])
        inDegrees[edge[0]]++
    }

    // Perform topological sorting using a queue
    val queue: Queue<Int> = LinkedList()
    for (i in 0 until numCourses) {
        if (inDegrees[i] == 0) {
            queue.offer(i)
        }
    }

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        for (neighbor in graph[node]) {
            inDegrees[neighbor]--
            if (inDegrees[neighbor] == 0) {
                queue.offer(neighbor)
            }
        }
    }

    // If there is any node left with in-degree greater than 0, it means there is a cycle
    for (inDegree in inDegrees) {
        if (inDegree > 0) {
            return false
        }
    }

    return true
}

fun main() {
    // Example usage
    val numCourses = 4
    val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 1), intArrayOf(3, 2))

    val result = canFinish(numCourses, prerequisites)
    println("Can finish tasks: $result")
}


//2. Alien Dictionary
import java.util.*

fun alienOrder(words: Array<String>): String {
    val graph = mutableMapOf<Char, MutableList<Char>>()
    val inDegrees = mutableMapOf<Char, Int>()

    // Initialize the graph and in-degrees
    for (word in words) {
        for (char in word) {
            graph[char] = mutableListOf()
            inDegrees[char] = 0
        }
    }

    // Build the graph and in-degrees based on adjacent words
    for (i in 1 until words.size) {
        val word1 = words[i - 1]
        val word2 = words[i]
        val minLength = minOf(word1.length, word2.length)

        for (j in 0 until minLength) {
            val char1 = word1[j]
            val char2 = word2[j]

            if (char1 != char2) {
                graph[char1]?.add(char2)
                inDegrees[char2] = inDegrees.getOrDefault(char2, 0) + 1
                break
            }
        }
    }

    // Perform topological sorting using a queue
    val result = StringBuilder()
    val queue: Queue<Char> = LinkedList()

    for (char in inDegrees.keys) {
        if (inDegrees[char] == 0) {
            queue.offer(char)
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        result.append(current)

        for (neighbor in graph[current] ?: emptyList()) {
            inDegrees[neighbor] = inDegrees[neighbor]!! - 1
            if (inDegrees[neighbor] == 0) {
                queue.offer(neighbor)
            }
        }
    }

    // Check for cycle (if not all characters are visited)
    return if (result.length == inDegrees.size) result.toString() else ""
}

fun main() {
    // Example usage
    val words = arrayOf("wrt", "wrf", "er", "ett", "rftt")

    val result = alienOrder(words)
    println("Alien Dictionary Order: $result")
}


/*
Tasks Scheduling:
The canFinish function determines whether it is possible to finish all tasks given the prerequisites. 
It uses topological sorting to check for cycles in a directed graph.
Alien Dictionary:
The alienOrder function determines the lexicographically smallest order of characters in an alien language based on a given list 
of words. It uses topological sorting to find the order of characters.
*/
