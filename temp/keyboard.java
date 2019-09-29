class Solution {
    public int calculateTime(String keyboard, String word) {
        
        if(word == null || word.length() < 1)
            return 0;
        
        int time = 0;
        char prev = keyboard.charAt(0);
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keyboard.length();i++) {
            map.put(keyboard.charAt(i), i);
        }
        
        for(char c : word.toCharArray()) {
            
            time += Math.abs(map.get(c) - map.get(prev));
            prev = c;
            
        }
     
        return time;
    }
}

class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for(int i = 0; i < keyboard.length(); i++) {
            char ch = keyboard.charAt(i);
            index[ch - 'a'] = i;
        }
        int time = 0;
        int prev = 0;
        for(int j = 0; j < word.length(); j++) {
        	int cur = index[word.charAt(j) - 'a'];
        	time += Math.abs(cur - prev);
        	prev = cur;
        }
        return time;
    }
}
