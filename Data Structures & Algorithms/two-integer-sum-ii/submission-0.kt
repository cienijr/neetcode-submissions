class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size-1

        while (left < right) {
            val currentSum = numbers[left] + numbers[right]
            when {
                currentSum < target -> left++
                currentSum > target -> right--
                else -> break
            }
        }

        return intArrayOf(left+1, right+1)
    }
}
