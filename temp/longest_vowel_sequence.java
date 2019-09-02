// "static void main" must be defined in a public class.
// idea is to find the longest running vowel substring and remove left and right sides

public class Main {
    
    public static void main(String[] args) {
        
        String str = "mneordcaffg";
        System.out.println(getlen(str));
    }
    
    static int getlen(String str) {
        
        int start = 0;
        int end = str.length() - 1;
        
        while(start < str.length() && isVowel(str.charAt(start)))
            start++;
        
        while(end >= 0 && isVowel(str.charAt(end)))
            end--;
        
        if(start >= str.length())
            return str.length();
        
        int total = 0, len = 0;
        for(int i = start + 1; i <= end; i++) {
            if(isVowel(str.charAt(i)))
                total++;
            else
                total = 0;
            len = Math.max(len, total);
        }
        
        return len + (start - 1) + (str.length() - end);
    }
    
    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
}



