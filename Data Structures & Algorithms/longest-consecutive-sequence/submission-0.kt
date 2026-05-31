class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val seen = mutableSetOf<Int>()

        nums.forEach { num ->
            seen += num
        }

        var maxSeq = 0
        val uniqueNums = seen.toList()
        for (num in uniqueNums) {
            if (num !in seen) continue
            
            var count = 0
            var current = num
            while (current in seen) {
                seen -= current
                count += 1
                current++
            }

            current = num-1
            while (current in seen) {
                seen -= current
                count += 1
                current--
            }

            maxSeq = max(maxSeq, count)
        }

        return maxSeq    
    }
}
