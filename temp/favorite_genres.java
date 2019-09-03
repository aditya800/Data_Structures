// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        Map<String, List<String>> userMap = new HashMap();
        Map<String, List<String>> genreMap = new HashMap();
        userMap.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userMap.put("Emma", Arrays.asList("song5", "song6", "song7"));
        genreMap.put("Rock", Arrays.asList("song1", "song3"));
        genreMap.put("Dubstep", Arrays.asList("song7"));
        genreMap.put("Techno", Arrays.asList("song2", "song4"));
        genreMap.put("Pop", Arrays.asList("song5", "song6"));
        genreMap.put("Jazz", Arrays.asList("song8", "song9"));
        group(userMap, genreMap);
       // System.out.println(userMap);
    }
    
    static void group(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
       
       Map<String, String> songs = new HashMap();
        
       for(Map.Entry<String, List<String>> entry : genreMap.entrySet()) {
           
           String key = entry.getKey();
           List<String> l1 = entry.getValue();
           for(String str : l1) {
              songs.put(str, key);
           }
       }
        
       for(Map.Entry<String, List<String>> entry : userMap.entrySet()) {
           
           Map<String, Integer> maxMap = new HashMap();
           List<String> l1 = entry.getValue();
           int max = 0;
           for(String str : l1) {
               if(songs.containsKey(str)) {
                   maxMap.put(songs.get(str), maxMap.getOrDefault(songs.get(str), 0) + 1);
                   if(maxMap.get(songs.get(str)) > max)
                       max = maxMap.get(songs.get(str));
               }
           }
           
           System.out.println(maxMap);
           Set<String> l2 = new HashSet();
           for(Map.Entry<String, Integer> entry1 : maxMap.entrySet()) {  
               if(entry1.getValue() == max)) {
                    l2.add(entry1.getKey()); 
               }
          // }
         
           userMap.put(entry.getKey(), new ArrayList<>(l2));
        
       //System.out.println(songs);
       System.out.println(userMap);
    }
    
}



