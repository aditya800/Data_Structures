public static String breakPalindrome(String s) {
    // Write your code here
        
        StringBuilder sb = new StringBuilder(s);
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < s.length(); i++) {
                if(c < s.charAt(i)) {
                    sb.setCharAt(i, c);
                    if(!isPalindrome(sb.toString())) {
                        return sb.toString();
                    }
                }
            }
        }

        return new String("IMPOSSIBLE");
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < (n / 2); i++) {
            if(s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
