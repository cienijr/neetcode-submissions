class Solution {
    fun isPalindrome(s: String): Boolean {
        val sanitized = s.lowercase().filter { it.isLetterOrDigit() }

        var left = 0
        var right = sanitized.length - 1

        while (left < right) {
            if (sanitized[left] != sanitized[right])
                return false

            left++
            right--
        }

        return true
    }
}
