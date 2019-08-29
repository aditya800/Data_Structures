// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println(euclids(23, 21));

    }
    
    static long euclids(long a, long b) {
        
        return b == 0 ? a : euclids(b, a % b);
        
    }
    
}
