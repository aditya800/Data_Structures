// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] arr = {3, 2, 1, 7, -1, 93, 29, 0, 10, 4};
        quick_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    static void quick_sort(int[] arr, int low, int high) {
        
        if(low < high) {
            int pi = partition(arr, low, high);
            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }
        
    }
    
    static int partition(int[] arr, int low, int high) {
        
        Random r = new Random(0);
        int pivot = r.nextInt(high - low + 1) + low;
        int temp1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp1;
        int pi = low;
        
        for(int i = low; i < high; i++) {
            if(arr[i] <= pivot) {
                int temp = arr[low];
                arr[low] = arr[pi];
                arr[pi++] = temp;
            }
        }
        
        int temp = arr[pi]; 
        arr[pi] = arr[high];
        arr[high] = temp;
        return pi;
    }

}




