class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var leftIdx = 0
        var rightIdx = nums.size - 1

        val sortedNums = nums.sorted()

        val minIdxMap = mutableMapOf<Int, Int>()
        val maxIdxMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, num ->
            if (num !in minIdxMap)
                minIdxMap[num] = i
            maxIdxMap[num] = i
        }

        while (leftIdx < rightIdx) {
            val sum = sortedNums[leftIdx] + sortedNums[rightIdx]

            if (sum < target)
                leftIdx++
            else if (sum > target)
                rightIdx--
            else break
        }

        val leftNum = sortedNums[leftIdx]
        val rightNum = sortedNums[rightIdx]

        val leftMin = minIdxMap[leftNum]!!
        val rightMin = minIdxMap[rightNum]!!
        val leftMax = maxIdxMap[leftNum]!!
        val rightMax = maxIdxMap[rightNum]!!

        return if (leftMin < rightMin) 
            intArrayOf(leftMin, rightMax) 
        else
            intArrayOf(rightMin, leftMax)

    }
}
