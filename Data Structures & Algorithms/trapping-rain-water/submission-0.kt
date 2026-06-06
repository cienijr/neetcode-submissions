class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1

        var leftMax = height[left]
        var rightMax = height[right]

        var result = 0
        while (left < right) {
            if (leftMax < rightMax) {
                left++
                leftMax = maxOf(leftMax, height[left])

                result += leftMax - height[left]
            } else {
                right--
                rightMax = maxOf(rightMax, height[right])

                result += rightMax - height[right]
            }
        }

        return result
    }
}
