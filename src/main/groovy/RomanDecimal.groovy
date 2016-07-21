// see end-of-file for license information

/**
 * see how awesome Groovy is (and how awesome Dierk Koenig can implement...)
 */
class RomanDecimal {

    static lex = [ I:1, IV:4, V:5, IX:9, X:10, XL:40, L:50, XC:90, C:100, CD:400, D:500, CM:900, M:1000 ]

    /*
     * http://groovyconsole.appspot.com/script/6003
     *
     * based upon code by Dierk Koenig
     */
    static int romanToDecimal(String romanNr) {
        def roman = romanNr.toUpperCase()
        if (lex[roman])       return lex[roman]
        if (lex[roman[0..1]]) return lex[roman[0..1]] + romanToDecimal(roman[2..-1])
        return lex[roman[0]]    + romanToDecimal(roman[1..-1])
    }

    /*
    based upon code found on Stackoverflow
    http://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java

     */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int times = 0
        String[] romans = [ "I", "IV", "V", "IX", "X", "XL", "L","XC", "C", "CD", "D", "CM", "M" ] as String[]
        int[] ints = [ 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,900, 1000 ] as int[]
        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }

}
