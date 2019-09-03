// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        String[] str = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(reorder_log(str));
    }
    
    static List<String> reorder_log(String[] logs) {
        
        List<String> l1 = new ArrayList();
        List<String> l2 = new ArrayList();
        
        for(String log : logs) {
            char ch = log.substring(log.indexOf(" ") + 1).charAt(0);
            if(Character.isLetter(ch))
                l1.add(log);
            else 
                l2.add(log);
        }
        
        Collections.sort(l1, new Comparator<String>() {
            public int compare(String o1, String o2) {
			         String s1 = o1.substring(o1.indexOf(" ") + 1);
			         String s2 = o2.substring(o2.indexOf(" ") + 1);  
              return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            }
        });
        
       l1.addAll(l2); 
        
       return l1;
    }
    
}



