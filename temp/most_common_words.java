class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph += " ";
        
        Set<String> set = new HashSet();
        for(String ban: banned) {
            set.add(ban.toLowerCase());
        }
        
       Map<String, Integer> map = new HashMap();
       int max = Integer.MIN_VALUE;
       String s = "";
       StringBuilder sb = new StringBuilder();
       for(char ch : paragraph.toCharArray()) {
           
           if(Character.isLetter(ch)) {
               sb.append(Character.toLowerCase(ch));
           } else if(sb.length() > 0) {
               String finalword = sb.toString();
               if(!set.contains(finalword)) {
                   map.put(finalword, map.getOrDefault(finalword, 0) + 1);
                   if(map.get(finalword) > max) {
                       max = map.get(finalword);
                       s = finalword;
                   }
               }
               sb = new StringBuilder();
           }
           
       }
       
       // List<String> mostFreq = new ArrayList(); 
       // for(String str : map.keySet()) {
       //   if(map.get(str) == max)
       //       mostFreq.add(str);
       // } 
       // return mostFreq; 
        
       return s; 
    }
}
