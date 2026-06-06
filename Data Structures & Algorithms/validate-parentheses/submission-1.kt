class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        fun popExpected(expected: Char) = 
            stack.isNotEmpty() && stack.pop() == expected

        s.forEach { c ->
            when (c) {
                '(', '{', '[' -> stack.push(c)
                ')' -> if (!popExpected('(')) return false
                '}' -> if (!popExpected('{')) return false
                ']' -> if (!popExpected('[')) return false
            }
        }

        return stack.isEmpty()
    }
}
