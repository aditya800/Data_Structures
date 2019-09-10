// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");     
        
        int[] arr = {5, 0, 1, 2, 4};
        merge_sort(arr);
        System.out.println(Arrays.toString(arr));
       
    }
    
    static void merge_sort(int[] arr) {
        
        int n = arr.length;
        if(n < 2)
            return;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for(int i = 0; i<left.length;i++) {
            left[i] = arr[i];
        }
        for(int i = mid; i<right.length;i++) {
            right[i - mid] = arr[i];
        }
        merge_sort(left);
        merge_sort(right);
        merge(arr, left, right);
    }
    
    static void merge(int[] arr, int[] left, int[] right) {
        
        int lefti = 0, righti = 0;
        int k = 0;
        
        while(lefti < left.length && righti < right.length) {
            
            if(left[lefti] < right[righti]) {
                arr[k++] = left[lefti++];
            } else {
                arr[k++] = right[righti++];
            }
        }
        
        while(lefti < left.length) {
            arr[k++] = left[lefti++];
        }
        
        while(righti < right.length) {
            arr[k++] = right[righti];
        }
        
    }
    
}




