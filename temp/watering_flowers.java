public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] plants =  {2, 4, 7, 7, 2};
        int capacity1 = 5;
        int capacity2 = 7;
        System.out.println(solution(plants, capacity1, capacity2));
    }
    
    static int solution(int[] plants, int capacity1, int capacity2) {
        
        if(plants == null || plants.length == 0)
            return 0;
        
        if(plants.length == 1)
            return 1;
        
        int left = 0, right = plants.length - 1, c1 = capacity1, c2 = capacity2, refil = 2;
            
        while(left <= right) {
            
            if(left == right) {
                
                if(c1 + c2 < plants[left])
                    refil++;
                
                break;
                    
            }
            
            if(c1 < plants[left]) {
                c1 = capacity1;
                refil++;
            }
            
            if(c2 < plants[right]) {
                c2 = capacity2;
                refil++;
            }
            
            c1 = c1 - plants[left++];
            c2 = c2 - plants[right--];
            
        }
        
        return refil;
    }
}

