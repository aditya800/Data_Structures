public static void main(String []args){
        System.out.println("Hello World");
        HashMap<String, List<String>> songGenres = new HashMap<>();
        List<String> l1 = Arrays.asList("song1", "song3");
        songGenres.put("Rock", l1);
        l1 = Arrays.asList("song7");
        songGenres.put("Dubstep", l1);
        l1 = Arrays.asList("song2", "song4");
        songGenres.put("Techno", l1);
        l1 = Arrays.asList("song5", "song6");
        songGenres.put("Pop", l1);
        l1 = Arrays.asList("song8", "song9");
        songGenres.put("Jazz", l1);
        System.out.println(songGenres);
        
        HashMap<String, List<String>> userMap = new HashMap<>();
        l1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
        userMap.put("David", l1);
        l1 = Arrays.asList("song5", "song6", "song7");
        userMap.put("Emma", l1);
        System.out.println(userMap);
        System.out.println();
        
        
        /** code **/ 
        HashMap<String, String> songMap = new HashMap<>();
        if(songGenres != null) {
            for(Map.Entry<String, List<String>> entry : songGenres.entrySet()) {
                    String genre = entry.getKey();
                    List<String> songs = entry.getValue();
                    if(songs != null) {
                        for(String song : songs) {
                            songMap.put(song, genre);
                        }               
                    }
            }
        }
        
        HashMap<String, List<String>> result = new HashMap<>();
        if(userMap != null) {
            for(Map.Entry<String, List<String>> entry : userMap.entrySet()) {
                
                String username = entry.getKey();
                result.put(username, new ArrayList<>());
                List<String> songs = entry.getValue();
                if(songs != null) {
                    HashMap<String, Integer> countMap = new HashMap<>();
                    int max = 0;
                    for(String song : songs) {
                        if(songMap.containsKey(song)) {
                            String genre = songMap.get(song);
                            countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                            max = Math.max(max, countMap.get(genre));
                        }
                    }
                    for(String word : countMap.keySet()) {
                       if(countMap.get(word) == max) {
                           result.get(username).add(word);
                       } 
                    }
                }
                
            }
        }
        
        System.out.println(result);
     }
