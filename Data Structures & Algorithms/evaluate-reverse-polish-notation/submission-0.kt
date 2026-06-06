class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val operands = ArrayDeque<Int>()

        fun execute(op: (Int, Int) -> Int) {
            val b = operands.pop()
            val a = operands.pop()

            operands.push(op(a, b))
        }

        tokens.forEach { token ->
            when (token) {
                "+" -> execute({ a, b -> a + b })
                "-" -> execute({ a, b -> a - b })
                "*" -> execute({ a, b -> a * b })
                "/" -> execute({ a, b -> a / b })
                else -> operands.push(token.toInt())
            }
        }

        return operands.pop()
    }
}
