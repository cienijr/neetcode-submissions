class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val size = nums.size
        val output = IntArray(size)

        var acc = 1
        for (i in (size-1) downTo 1) {
            acc *= nums[i]
            output[i] = acc
        }

        acc = 1
        for (i in 0..(size-2)) {
            acc *= nums[i]
            nums[i] = acc
        }

        output[0] = output[1]
        for (i in 1..(size-2)) {
            output[i] = output[i+1] * nums[i-1]
        }
        output[size-1] = nums[size-2]

        return output
    }
}
