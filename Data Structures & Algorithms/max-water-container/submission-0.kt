class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size-1

        var max = -1
        while (left < right) {
            val width = right - left
            val height = minOf(heights[left], heights[right])

            max = maxOf(max, width*height)

            if (heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }

        return max
    }
}
