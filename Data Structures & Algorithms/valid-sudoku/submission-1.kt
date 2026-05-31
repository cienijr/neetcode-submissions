class Solution {
    fun checkSet(current: Char, seen: MutableSet<Char>): Boolean {
        if (current == '.') {
            return true
        }

        if (current in seen) {
            return false
        }

        seen += current
        return true
    }

    fun verifyRowsAndCols(board: Array<CharArray>): Boolean {
        for (i in 0..<9) {
            val rowSet = mutableSetOf<Char>()
            val colSet = mutableSetOf<Char>()
            for (j in 0..<9) {
                if (!checkSet(board[i][j], rowSet)) {
                    return false
                }
                if (!checkSet(board[j][i], colSet)) {
                    return false
                }
            }
        }

        return true
    }

    fun verifyBox(board: Array<CharArray>, offsetRow: Int, offsetCol: Int): Boolean {
        val boxSet = mutableSetOf<Char>()
        for (i in 0..<3) {
            for (j in 0..<3) {
                if (!checkSet(board[i+offsetRow][j+offsetCol], boxSet)) {
                    return false
                }
            }
        }

        return true
    }

    fun verifyBoxes(board: Array<CharArray>): Boolean {
        for (i in 0..<3) {
            for (j in 0..<3) {
                if (!verifyBox(board, i*3, j*3)) {
                    return false
                }
            }
        }

        return true
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return verifyRowsAndCols(board) && verifyBoxes(board)
    }
}
