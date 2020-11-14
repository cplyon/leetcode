fun main()
{
    val s = "([{}]"
    println(isValid(s))

}

fun isValid(s: String): Boolean {

    if (s.length % 2 != 0) {
        return false
    }

    val parens = ArrayDeque<Char>()
    for (c in s) {
        when (c) {
            '(', '[', '{' -> parens.addFirst(c)
            ')' -> {
                if (parens.isEmpty() || parens.first() != '(') {
                    return false
                }
                parens.removeFirst()
            }
            ']' -> {
                if (parens.isEmpty() || parens.first() != '[') {
                    return false
                }
                parens.removeFirst()
            }
            '}' -> {
                if (parens.isEmpty() || parens.first() != '{') {
                    return false
                }
                parens.removeFirst()
            }                        
             
        }
    }
    return parens.isEmpty()
}