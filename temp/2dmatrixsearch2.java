// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        List<List<Integer>> l1 = new ArrayList();
        l1.add(Arrays.asList(1, 4,  7, 11, 15));
        l1.add(Arrays.asList(2, 5,  8, 12, 19));
        System.out.println(search2d(l1, -2));
    }
    
    static boolean search2d(List<List<Integer>> matrix, int target) {
        
        int start = 0, end = matrix.get(0).size() - 1;
        
        while(start < matrix.size() && end >= 0) {
            if(matrix.get(start).get(end) == target)
                return true;
            else if(matrix.get(start).get(end) < target)
                start++;
            else
                end--;
        }
        
        return false;
    }
    
}



