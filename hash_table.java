 //contact book class that can have duplicate names
    // each contact is a string of names and it is equal to another if it has the same strings
    class ContactList {
        
        public List<String> names;
        
        ContactList(List<String> names) {
            this.names = names;
        }
        
        @Override
        public boolean equals(Object obj) {
           
            if(obj == null || (obj instanceof ContactList)) {
                return false;
            }
            
            return this == obj ? true : new HashSet(names).equals(new HashSet(((ContactList)obj).names));
            
        }
        
        @Override
        public int hashCode() {
            return new HashSet(names).hashCode();
        }
        
    }
    
    // example of a hash function
    static int rolling_hash(String str, int mod) {
        
        int kMult = 997;
        int val = 0;
        
        for(int i=0;i<str.length();i++) {
           char c = str.charAt(i); 
           val = (val * kMult * c) % mod;
        }
        
        return val;
    }
    
    
    // group anagrams
    public static List<List<String>> findAnagrams(List<String> words) {
        
        Map<String, List<String>> map = new HashMap();
        
        for(String word : words) {
            char[] sortedString = word.toCharArray();
            Arrays.sort(sortedString);
            String back = new String(sortedString);
            if(!map.containsKey(back)) {
                map.put(back, new ArrayList<String>());
            }
            map.get(back).add(word);
        }
        
        List<List<String>> l1 = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            l1.add(entry.getValue());
        }
        
        return l1;
    }
