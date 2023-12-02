// Strategy interface
interface SortingStrategy {
    fun sort(data: MutableList<Int>)
}

// Concrete strategies
class BubbleSortStrategy : SortingStrategy {
    override fun sort(data: MutableList<Int>) {
        println("Using Bubble Sort")
        // Implementation of bubble sort
        // ...
    }
}

class QuickSortStrategy : SortingStrategy {
    override fun sort(data: MutableList<Int>) {
        println("Using Quick Sort")
        // Implementation of quick sort
        // ...
    }
}

class MergeSortStrategy : SortingStrategy {
    override fun sort(data: MutableList<Int>) {
        println("Using Merge Sort")
        // Implementation of merge sort
        // ...
    }
}

// Context class
class Sorter(private val strategy: SortingStrategy) {
    fun applyStrategy(data: MutableList<Int>) {
        strategy.sort(data)
    }
}

fun main() {
    val data = mutableListOf(5, 2, 8, 3, 1)

    // Using Bubble Sort
    val bubbleSorter = Sorter(BubbleSortStrategy())
    bubbleSorter.applyStrategy(data.toMutableList())

    // Using Quick Sort
    val quickSorter = Sorter(QuickSortStrategy())
    quickSorter.applyStrategy(data.toMutableList())

    // Using Merge Sort
    val mergeSorter = Sorter(MergeSortStrategy())
    mergeSorter.applyStrategy(data.toMutableList())
}
