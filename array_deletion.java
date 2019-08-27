public class Main {
    public static void main(String[] args) {
        
       int original_array[] = {4, 3, 2, 1, 6, 8};
       System.out.println("Original Array: " + Arrays.toString(original_array));
       int[] modified_array = remove(original_array, 0); // deleting at index 0
       System.out.println("Modified Array: " + Arrays.toString(modified_array));
        
    }
    
    static int[] remove(int[] arr, int i) {
       
       if(i >= arr.length || arr == null || arr.length == 0 || i < 0) 
           return arr;
        
       int num = arr[arr.length - 1];
        
       for(int j = arr.length - 2; j >= i; j--) {
           int temp = arr[j];
           arr[j] = num;
           num = temp;   
       }
        
       int[] modified_array = Arrays.copyOfRange(arr, 0, arr.length - 1); 
       return modified_array;
    }
    
    //runs in O(2N - i) time where i is the index of the element being deleted  
    
}
