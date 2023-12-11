/*
Use this technique to build a solution incrementally and follow the approach that
if the current solution can’t lead to a valid solution, abandon it and backtrack (or go back) to try another solution.
*/

//1. Combination Sum
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val currentCombination = mutableListOf<Int>()

    fun backtrack(startIndex: Int, remainingTarget: Int) {
        if (remainingTarget < 0) {
            return
        }

        if (remainingTarget == 0) {
            result.add(ArrayList(currentCombination))
            return
        }

        for (i in startIndex until candidates.size) {
            currentCombination.add(candidates[i])
            backtrack(i, remainingTarget - candidates[i])
            currentCombination.removeAt(currentCombination.size - 1)
        }
    }

    backtrack(0, target)
    return result
}

fun main() {
    // Example usage
    val candidates = intArrayOf(2, 3, 6, 7)
    val target = 7

    val result = combinationSum(candidates, target)
    println("Combinations for target $target: $result")
}

//2. Sudoku Solver
fun solveSudoku(board: Array<CharArray>) {
    fun isValid(row: Int, col: Int, num: Char): Boolean {
        // Check if the number is not present in the current row, column, and 3x3 subgrid
        for (i in 0 until 9) {
            if (board[row][i] == num || board[i][col] == num || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false
            }
        }
        return true
    }

    fun solve(): Boolean {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == '.') {
                    for (num in '1'..'9') {
                        if (isValid(i, j, num)) {
                            board[i][j] = num
                            if (solve()) {
                                return true
                            }
                            board[i][j] = '.' // Backtrack
                        }
                    }
                    return false // No valid number for the current cell
                }
            }
        }
        return true // All cells are filled
    }

    solve()
}

fun printSudoku(board: Array<CharArray>) {
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            print("${board[i][j]} ")
        }
        println()
    }
}

fun main() {
    // Example usage
    val sudokuBoard = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println("Sudoku Board:")
    printSudoku(sudokuBoard)

    solveSudoku(sudokuBoard)

    println("\nSolved Sudoku Board:")
    printSudoku(sudokuBoard)
}
