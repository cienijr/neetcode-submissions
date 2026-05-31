class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numbersSeen = mutableSetOf<Int>()

        nums.forEach { num ->
            if (num in numbersSeen)
                return true
            
            numbersSeen += num
        }

        return false
    }
}
