// "static void main" must be defined in a public class.
public class Main {

    public static void main(String[] args) {
        
        int n = 10;
        fib(n);
        
    }

    static void fib(int n) {
    
        int a = 0;
        int b = 1;
        int i = 0;
        
        while(i < n) {
            System.out.println(b);
            int temp = a;
            a = b;
            b = b + temp;
            i++;
        }
        
    }
    
}


