fun main() {

    val s = "LXI"
    println(romanToInt(s))

}

/*
    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
    It is guaranteed that s is a valid roman numeral in the range [1, 3999]
    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 */

fun romanToInt(s: String): Int {
    var num = 0
    var i = 0
    while (i < s.length) {

        println(s[i])

        when (s[i]) {
            'I' -> {
                // could be I, II, III, IV, IX
                if ( (i == s.length-1) || (s[i+1] == 'I') ) {
                    num+=1
                } else if (s[i+1] == 'V') {
                    num+=4
                    i+=1
                } else if (s[i+1] == 'X') {
                    num+=9
                    i+=1    
                } else {
                    num+=1
                }
            }
            'V' -> {
                // could be V, VI, VII, VIII
                num+=5
            }
            'X' -> {
                // could be X, XI..., XX, XXX, XL, XC
                if ( (i == s.length-1) || (s[i+1] == 'X') ) {
                    num+=10
                } else if (s[i+1] == 'L') {
                    num+=40
                    i+=1
                } else if (s[i+1] == 'C') {
                    num+=90
                    i+=1    
                } else {
                    num+=10
                }
            }
            'L' -> {
                // could be L, LI...
                num+=50
            }
            'C' -> {
                // could be C, CI..., CC, CCC, CD, CM
                if ( (i == s.length-1) || (s[i+1] == 'C') ) {
                    num+=100
                } else if (s[i+1] == 'D') {
                    num+=400
                    i+=1
                } else if (s[i+1] == 'M') {
                    num+=900
                    i+=1    
                } else {
                    num+=100
                }
            }
            'D' -> {
                // could be D, DI...
                num+=500
            }
            'M' -> {
                // could be M, MI..., mm, MMM ... MMMCMXCIX
                num+=1000            
            }
        }
        i++
    }
    return num
}