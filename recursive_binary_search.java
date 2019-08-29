// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 3, 4, 8, 9, 12};
        int index = recursive_binary_search(arr, 5, 0, arr.length - 1);
        System.out.println(index);

    }
    
    static int recursive_binary_search(int[] arr, int key, int low, int high) {
     
        int mid = (high + low) / 2;
        
        if(arr[mid] == key)
            return mid;
        else if(low > high)
            return -(mid + 1);
        else {
            if(arr[mid] > key)
                return recursive_binary_search(arr, key, low, mid - 1);
            else
                return recursive_binary_search(arr, key, mid + 1, high);
        }
        
    }
    
}

// Recursive call stack -> O(N) memory 
