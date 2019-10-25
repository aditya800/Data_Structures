public static List<String> genrate(List<String> phrases) {
   Map<String, List<Integer>> map = new HashMap<>();
        int i = 0;
        
        for(String word : phrases) {
            
            String firstWord = word.substring(0, word.indexOf(' '));
            
            if(!map.containsKey(firstWord)) {
                map.put(firstWord, new ArrayList());
            }
        
            map.get(firstWord).add(i++);
        }
        
        List<String> l1 = new ArrayList();
        i = 0;
        
        for(String word : phrases) {
            String lastword = word.substring(word.lastIndexOf(' ') + 1);
            if(map.containsKey(lastword)) {
                for(Integer index : map.get(lastword)) {
                    if(index != i) {
                        String[] words = phrases.get(index).split(" ", 2);
                        StringBuilder sb = new StringBuilder();
                        sb.append(word);
                        sb.append(' ');
                        sb.append(words[1]);
                        l1.add(sb.toString());
                    }
                }
            }
            
            i++;
        }
        
        return l1;
}
