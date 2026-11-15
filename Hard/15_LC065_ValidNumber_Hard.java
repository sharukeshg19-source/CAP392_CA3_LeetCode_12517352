class Solution {
    public boolean isNumber(String s) {
        boolean digit = false;
        boolean dot = false;
        boolean exponent = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                digit = true;
            }
            else if (ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else if (ch == '.') {
                if (dot || exponent) {
                    return false;
                }
                dot = true;
            }
            else if (ch == 'e' || ch == 'E') {
                if (exponent || !digit) {
                    return false;
                }
                exponent = true;
                digit = false;
            }
            else {
                return false;
            }
        }

        return digit;
    }
}
