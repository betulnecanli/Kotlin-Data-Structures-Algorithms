/*
st Search (DFS) or Breadth-First Search (BFS). 
Let's tackle three common problems: "Number of Islands," "Flood Fill," and "Cycle in a Matrix." 
*/
//1. Number of Islands
/*
Problem Statement:
Given a 2D grid representing a map, where '1' represents land and '0' represents water, count the number of islands. 
An island is formed by connecting adjacent lands horizontally or vertically. Assume the grid is surrounded by water.

Explanation:
This problem can be solved using Depth-First Search (DFS). 
The idea is to traverse the entire grid, and whenever we encounter a '1' (land),
we increment the island count and perform DFS to mark all connected lands as visited (change '1' to '0').
*/
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) {
        return 0
    }

    val numRows = grid.size
    val numCols = grid[0].size
    var numIslands = 0

    fun dfs(row: Int, col: Int) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || grid[row][col] == '0') {
            return
        }

        grid[row][col] = '0' // Mark the current cell as visited

        // Explore neighbors in all four directions
        dfs(row + 1, col)
        dfs(row - 1, col)
        dfs(row, col + 1)
        dfs(row, col - 1)
    }

    for (row in 0 until numRows) {
        for (col in 0 until numCols) {
            if (grid[row][col] == '1') {
                numIslands++
                dfs(row, col)
            }
        }
    }

    return numIslands
}

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    val result = numIslands(grid)
    println("Number of Islands: $result")
}


//2. Flood Fill
/*
Problem Statement:
Given an image represented by a 2D array of integers, and starting pixel (sr, sc) representing the starting pixel and a new color, 
replace the color of the starting pixel and all adjacent pixels with the same color with the new color.

Explanation:
This problem is a classic application of the Depth-First Search (DFS) algorithm. 
The idea is to start DFS from the initial pixel, and for each pixel visited, change its color to the new color. 
The DFS ensures that all connected pixels of the same color are updated.
*/
fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    val numRows = image.size
    val numCols = image[0].size
    val originalColor = image[sr][sc]

    fun dfs(row: Int, col: Int) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || image[row][col] != originalColor) {
            return
        }

        image[row][col] = newColor // Change color of the current cell

        // Explore neighbors in all four directions
        dfs(row + 1, col)
        dfs(row - 1, col)
        dfs(row, col + 1)
        dfs(row, col - 1)
    }

    if (originalColor != newColor) {
        dfs(sr, sc)
    }

    return image
}

fun main() {
    val image = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1)
    )
    val sr = 1
    val sc = 1
    val newColor = 2

    val result = floodFill(image, sr, sc, newColor)
    println("Flood Fill Result:")
    result.forEach { row ->
        println(row.joinToString(" "))
    }
}

//3. Cycle in a Matrix
/*
Problem Statement:
Given an n x n matrix, determine if the matrix contains a cycle. 
A cycle is defined as a set of cells where the same value is traversed horizontally or vertically.

Explanation:
This problem can be solved using Depth-First Search (DFS) as well. The idea is to traverse the matrix and, for each cell, 
perform DFS to check if there is a cycle starting from that cell.
We mark cells as visited and keep track of the parent cell to avoid revisiting the same cell immediately.

*/
fun hasCycle(matrix: Array<IntArray>): Boolean {
    val numRows = matrix.size
    val numCols = matrix[0].size
    val visited = Array(numRows) { BooleanArray(numCols) }

    fun dfs(row: Int, col: Int, parentRow: Int, parentCol: Int): Boolean {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            return false
        }

        if (visited[row][col]) {
            return true
        }

        visited[row][col] = true

        val directions = arrayOf(-1, 0, 1, 0, -1)
        for (i in 0 until 4) {
            val newRow = row + directions[i]
            val newCol = col + directions[i + 1]

            if ((newRow != parentRow || newCol != parentCol) && matrix[newRow][newCol] == matrix[row][col]) {
                if (dfs(newRow, newCol, row, col)) {
                    return true
                }
            }
        }

        return false
    }

    for (row in 0 until numRows) {
        for (col in 0 until numCols) {
            if (!visited[row][col]) {
                if (dfs(row, col, -1, -1)) {
                    return true
                }
            }
        }
    }

    return false
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(3, 1, 2),
        intArrayOf(2, 3, 1)
    )

    val result = hasCycle(matrix)
    if (result) {
        println("The matrix has a cycle.")
    } else {
        println("The matrix does not have a cycle.")
    }
}

/*
These problems share the common theme of traversing a matrix and exploring adjacent elements based on certain conditions. 
The use of Depth-First Search (DFS) is common in such scenarios,
providing an efficient way to explore and mark elements in the matrix.

*/
