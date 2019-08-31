// "static void main" must be defined in a public class.
// why can binary search not be used from [0..i]? 
public class Main {
    
    public static void main(String[] args) {
        
        int[] arr = {2, 0, 1, 9, 3, 1, 2, -1};
        insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void insertion_sort(int[] arr) {
        
        for(int i = 1; i < arr.length; i++) {
            
            int val = arr[i];
            int j = i;
            while(j > 0 && arr[j-1] > val) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
        }
        
    }
}



