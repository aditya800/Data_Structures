// runs in O(N) time where N is the length of the string to be searched. Hash function can still have collisions, so equals() 
// can be also used after a match is found 

public class Main {
    public static void main(String[] args) {
        
       String haystack = "abcdabceabc"; 
       String needle = "abce";
       int index = indexOf(haystack, needle);
       System.out.println(index);
        
    }
    
   static int indexOf(String haystack, String needle) {
        
        if(needle == null || needle.length() < 1 )
            return 0;
        
        if(needle.length() > haystack.length()) 
            return -1;
        
        int tHash = 0, sHash = 0, base = 26, power = 1;
        
        for(int i=0; i<needle.length();i++) {
            power = i > 0 ? power * base : 1; 
            tHash = tHash * base + haystack.charAt(i);
            sHash = sHash * base + needle.charAt(i);
        }
        
        for(int i = needle.length(); i < haystack.length(); i++) {
            
             if(sHash == tHash)
                 return i - needle.length();
             
             tHash -= haystack.charAt(i - needle.length()) * power;
             tHash = tHash * base + haystack.charAt(i);
        }
        
        if(tHash == sHash)
            return haystack.length() - needle.length();
        
        return -1;
        
    }
    
}
