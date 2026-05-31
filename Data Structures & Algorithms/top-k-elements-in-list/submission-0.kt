class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (k == nums.size) return nums

        val freqs = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            freqs[num] = (freqs[num] ?: 0) + 1
        }

        val heap = PriorityQueue<Pair<Int, Int>>(k, compareBy { it.second })

        freqs.forEach { (num, freq) ->

            if (heap.size < k)
                heap.offer(num to freq)
            else {
                if (heap.peek().second < freq) {
                    heap.poll()
                    heap.offer(num to freq)
                }
            }
        }

        val topKPairs = heap.toTypedArray()
        return IntArray(k) { i ->
            topKPairs[i].first
        }
    }
}
