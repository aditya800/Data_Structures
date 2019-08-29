// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 3, 4, 8, 9, 12};
        int index = iterative_binary_search(arr, 2);
        System.out.println(index);
        
    }
    
    static int iterative_binary_search(int[] arr, int key) {
        
        int low = 0, high = arr.length - 1, mid = 0;
        
        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == key) {
               return mid;
            } else if(arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -mid;
        // binary search returns -(insertion index) if the index is not found 
    }
    
}



