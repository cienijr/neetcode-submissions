class Solution {
    fun MutableMap<Char, Int>.countUp(c: Char) {
        this[c] = (this[c] ?: 0) + 1
    }

    fun buildSummary(s: String): Map<Char, Int> {
        val summary = mutableMapOf<Char, Int>()
        s.forEach { summary.countUp(it) }
        return summary
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val summaries = strs.associateWith { buildSummary(it) }
        val strsBySummary = mutableMapOf<Map<Char, Int>, MutableList<String>>()

        for (str in strs) {
            val summary = summaries[str]!!
            val listToAppend = strsBySummary[summary] ?: mutableListOf()
            listToAppend.add(str)
            strsBySummary[summary] = listToAppend
        }

        return strsBySummary.values.toList()
    }
}
