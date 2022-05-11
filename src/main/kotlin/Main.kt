private val entries = mutableMapOf(
    1 to intArrayOf(0, 0, 0),
    3 to intArrayOf(3, 8, 9, 7, 6),
    4 to intArrayOf(1, 2, 3, 4)
)

private fun solution(A: IntArray, K: Int): IntArray {

    val zero = 0
    val one = 1
    var result = A

    if (result.isNotEmpty()) {
        for (step in zero until K) {
            val lastItem = result.last()
            val leftItems = result.sliceArray(IntRange(zero, result.lastIndex - one))
            result = intArrayOf(lastItem).plus(leftItems)
        }
    }

    return result
}

private fun IntArray.toStr() = this.map { it.toString() }

private fun printlnSolution(values: IntArray, key: Int) {
    println("(${values.toStr()}, $key) -> ${solution(values, key).toStr()}")
}

fun main() {
    entries.forEach { printlnSolution(it.value, it.key) }
}
