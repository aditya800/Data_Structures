// "static void main" must be defined in a public class.
public class Main {
    
    public static void main(String[] args) {
        
        Map<Character, Integer> map = new HashMap();
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        System.out.println(generateString(map));
    }
    
    public static String generateString(Map<Character, Integer> map) {
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
	            new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());
	    
		int cnt = 0;
		for (Map.Entry<Character, Integer> e: map.entrySet()) {
			cnt += e.getValue();
			maxHeap.add(e);
		}
	    
	    // only one char can be on hold
	    Map.Entry<Character, Integer> onHold = null;
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while (!maxHeap.isEmpty()) {
	    	Map.Entry<Character, Integer> cur = maxHeap.poll();
	    	sb.append(cur.getKey());
	    	
	    	if (onHold != null) {
	    		maxHeap.add(onHold);
	    		onHold = null;
	    	}
    		int curValue = cur.getValue();
    		if (curValue > 1) {
    			cur.setValue(curValue-1);
    			if (sb.length() >= 2 && cur.getKey() == sb.charAt(sb.length()-2)) { // on hold
	    			onHold = cur;
    			} else {  // add back to heap
    				maxHeap.add(cur);
    			}
    		}
	    
	    }
	    return sb.length() == cnt ? sb.toString(): "";
	}
}


