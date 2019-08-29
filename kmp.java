// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        String s = "abg";
        String t = "abdabeabgabc";
        
        int[] lps = new int[s.length()];
        //preprocessing of the lps table in O(M)
        for(int i = 1, k=0; i < s.length(); ) {
            
            if(s.charAt(i) == s.charAt(k)) {
                lps[i++] = ++k;
            } else {
                if(k > 0) 
                    k = lps[k-1];
                else
                    i++;
            }
        }
        
        int j = 0, i = 0;
        while(i < t.length()) {
            
            if(s.charAt(i) == t.charAt(j)) {
                j++;
                i++;
            }
                        
            if(j == s.length()) {
                System.out.println("Found at index: " + (i - j));
                break;
            } else if(s.charAt(i) != t.charAt(j) && i < t.length()) {
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }

        }
        
    }
}



