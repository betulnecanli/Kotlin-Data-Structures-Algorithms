/*
Use this technique when the problem asks to deal with permutations or combinations of a set of elements.
The "Subsets" coding pattern is different from the "Two Heaps" pattern.
The "Subsets" pattern is commonly used to generate all possible subsets of a set, while the 
"Two Heaps" pattern is used for efficiently solving problems involving two heaps, typically to find medians, intervals, 
or other order statistics.
*/

//1. String Permutations by changing case
fun letterCasePermutation(S: String): List<String> {
    val result = mutableListOf<String>()
    generatePermutations(S.toCharArray(), 0, result)
    return result
}

fun generatePermutations(chars: CharArray, index: Int, result: MutableList<String>) {
    if (index == chars.size) {
        result.add(String(chars))
        return
    }

    if (chars[index].isLetter()) {
        chars[index] = chars[index].toLowerCase()
        generatePermutations(chars, index + 1, result)

        chars[index] = chars[index].toUpperCase()
        generatePermutations(chars, index + 1, result)
    } else {
        generatePermutations(chars, index + 1, result)
    }
}

fun main() {
    val input = "a1b2"
    val result = letterCasePermutation(input)
    println("String Permutations by changing case: $result")
}


//2. Unique Generalized Abbreviations
fun generateAbbreviations(word: String): List<String> {
    val result = mutableListOf<String>()
    generateAbbreviationsRecursive(word.toCharArray(), 0, 0, StringBuilder(), result)
    return result
}

fun generateAbbreviationsRecursive(
    chars: CharArray,
    index: Int,
    count: Int,
    current: StringBuilder,
    result: MutableList<String>
) {
    if (index == chars.size) {
        if (count > 0) {
            current.append(count)
        }
        result.add(current.toString())
        return
    }

    // Abbreviate the current character
    generateAbbreviationsRecursive(chars, index + 1, count + 1, current, result)

    // Include the current character without abbreviation
    if (count > 0) {
        current.append(count)
    }
    current.append(chars[index])

    generateAbbreviationsRecursive(chars, index + 1, 0, current, result)

    // Backtrack
    current.setLength(current.length - (count + 1))
}

fun main() {
    val word = "word"
    val result = generateAbbreviations(word)
    println("Unique Generalized Abbreviations: $result")
}
