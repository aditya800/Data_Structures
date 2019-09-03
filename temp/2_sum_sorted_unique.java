// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 1, 2, 45, 46, 46};
        int d = 47;
        System.out.println(getunique(arr, d));
    }
    
    static int getunique(int[] arr, int d) {
        
        Set<List<Integer>> set = new HashSet();
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right) {
            
            int sum = arr[left] + arr[right];
            if(sum == d) {
                set.add(Arrays.asList(arr[left], arr[right]));
                left++;
                right--;
            } else if(sum < d) {
                left++;
            } else {
                right--;
            }
            
        }
    
        return set.size();
    }
    
}



