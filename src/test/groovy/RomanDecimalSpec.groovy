import spock.lang.Specification
import spock.lang.Unroll

// see end-of-file for license information


class RomanDecimalSpec extends Specification {

    @Unroll
    def "can convert roman to decimal"( String romanNr, int decimalNr ) {
        expect:
        RomanDecimal.romanToDecimal( romanNr ) == decimalNr

        RomanDecimal.intToRoman( decimalNr).toUpperCase() == romanNr.toUpperCase()

        where:

        romanNr  | decimalNr
        "i"      | 1
        "ii"     | 2
        "iii"    | 3
        "iv"     | 4
        "v"      | 5
        "vi"     | 6
        "vii"    | 7
        "VIII"   | 8
        "IX"     | 9
        "X"      | 10
        "XI"     | 11
        "XII"    | 12
        "XIII"   | 13
        "XIV"    | 14
    }
}
