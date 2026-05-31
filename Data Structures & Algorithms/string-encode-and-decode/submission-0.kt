class Solution {

    fun padInt(i: Int): String {
        return when {
            i < 10 -> "00$i"
            i < 100 -> "0$i"
            else -> "$i"
        }
    }

    fun encode(strs: List<String>): String {
        return buildString {
            append(padInt(strs.size))

            strs.forEach {
                append(padInt(it.length))
                append(it)
            }
        }
    }

    fun decode(str: String): List<String> {
        var offset = 0

        fun readInt(): Int {
            offset += 3
            return str.substring(offset-3, offset).trimStart('0').toIntOrNull() ?: 0
        }

        fun readString(size: Int): String {
            offset += size
            return str.substring(offset-size, offset)
        }

        return List(readInt()) {
            readString(readInt())
        }
    }
}
