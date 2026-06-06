class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortedNums = nums.sorted()

        fun twoSum(available: List<Int>, target: Int): List<List<Int>> {
            val seen = mutableMapOf<Int, Int>()
            val result = mutableSetOf<List<Int>>()

            available.forEach { num ->
                val complement = target - num
                val complementCount = seen[complement] ?: 0

                if (complementCount > 0) {
                    result.add(listOf(num, complement))
                    seen[complement] = complementCount - 1
                } else {
                    seen[num] = (seen[num] ?: 0) + 1
                }
            }

            return result.toList()
        }

        fun kSum(available: List<Int>, needed: Int, target: Int): List<List<Int>> {
            if (needed == 2) {
                return twoSum(available, target)
            }

            if (available.size < needed) {
                return emptyList()
            }

            val min = available.first()
            val max = available.last()

            if (target < min * needed || target > max * needed) {
                // impossible to fulfill
                return emptyList()
            }

            val result = mutableListOf<List<Int>>()
            val seen = mutableSetOf<Int>()

            for (i in 0..<available.size-1) {
                val current = available[i]

                if (current in seen) {
                    continue
                } else {
                    seen.add(current)
                }

                val tuples = kSum(available.subList(i+1, available.size), needed-1, target - current)

                tuples.forEach { tuple ->
                    val copy = tuple.toMutableList()
                    copy.add(current)
                    result.add(copy)
                }
            }

            return result
        }

        return kSum(sortedNums, 3, 0)
    }
}
