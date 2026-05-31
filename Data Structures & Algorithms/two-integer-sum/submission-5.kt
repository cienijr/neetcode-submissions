class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indices = mutableMapOf<Int, Int>()

        nums.forEachIndexed { i, num ->
            if ((target - num) in indices)
                return intArrayOf(indices[target - num]!!, i)
            else
                indices[num] = i
        }

        return intArrayOf()
    }
}
