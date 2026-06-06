class MinStack() {

    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)

        if (minStack.isNotEmpty())
            minStack.push(minOf(minStack.peek(), `val`))
        else
            minStack.push(`val`)
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}
