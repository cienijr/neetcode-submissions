class Solution {
    fun MutableMap<Char, Int>.countUp(c: Char) {
        this[c] = (this[c] ?: 0) + 1
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length)
            return false

        val countS = mutableMapOf<Char, Int>()
        val countT = mutableMapOf<Char, Int>()

        for (i in 0..<s.length) {
            countS.countUp(s[i])
            countT.countUp(t[i])
        }
        
        return countS == countT
    }
}
