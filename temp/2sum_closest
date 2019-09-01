// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        List<Integer> movie_duration = Arrays.asList(90, 85, 75, 60, 120, 150, 125);
        int d = 250;
        System.out.println(find_movies(movie_duration, d-30));
    }
    
    static List<Integer> find_movies(List<Integer> movie_duration, int d) {
        
        List<Integer> l1 = new ArrayList();
        Collections.sort(movie_duration);
        int left = 0, right = movie_duration.size() - 1;
        int max = Integer.MIN_VALUE;
        l1.add(-1);
        l1.add(-1);
        
        while(left < right) {
            
            int sum = movie_duration.get(left) + movie_duration.get(right);
            if(sum <= d) {
                if(sum > max) {
                    max = sum;
                    l1.set(0, movie_duration.get(left));
                    l1.set(1, movie_duration.get(right));
                }
                left++;
            } else {
                right--;
            }
        }
        
        return l1;
    }
}



