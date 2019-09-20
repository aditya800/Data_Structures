class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashSet<Integer> set = new HashSet();
        HashMap<Integer, List<Integer>> map = new HashMap();
        
        for(int[] edge : prerequisites) {
            
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<Integer>());
            }
            
            map.get(edge[1]).add(edge[0]);
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            
            int vertex = entry.getKey();
            Stack<Integer> stack = new Stack();
            HashSet<Integer> stackSet = new HashSet();
            
            if(!set.contains(vertex)) {
                stack.push(vertex);
                stackSet.add(vertex);
            }
            
            while(!stack.isEmpty()) {
                int ent = stack.peek();
                        
                if(map.containsKey(ent) && !set.contains(ent)) {
                    List<Integer> l1 = map.get(ent);
                    for(int k : l1) {
                        /* cycle detection */
                        if(stackSet.contains(k) && set.contains(k)) {
                            return false;
                        }
                        if(!set.contains(k)) {
                            stack.push(k);
                            stackSet.add(k);
                        }
                    }
                } else {
                    stack.pop();
                    stackSet.remove(ent);
                }
              set.add(ent);
           }
            
         }
        
        return true;
        
    }
    
}

