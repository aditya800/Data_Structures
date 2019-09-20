  public static List<String> findReachableBusinesses(Business startingBusiness, int distance) {
		
        List<String> l1 = new ArrayList();
        
        Stack<Business> stack = new Stack();
        stack.push(startingBusiness);
        Map<Business, Integer> distFromStart = new HashMap();
        map.put(startingbusiness, 0);
        
        while(!stack.isEmpty) {
            Business b1 = stack.pop();
            Map<Business, Integer> map = b1.getNearbyBusinesses();
            
            for(Map.Entry<Business, Integer> entry : map.entrySet()) {
               int totaldist = entry.getValue() + distFromStart.get(b1);
               if(totaldist <= distance) {
                   l1.add(entry.getKey().getName());
                   stack.push(entry.getKey());
                   distFromStart.put(entry.getKey(), totaldist);
               }
            }
            
        }
        
	}

TreeSet<Integer> tree = new TreeSet();
for(eventtype: eventypes) {
            for(event: eventtype) {
                if(numoccureneces >= average)
                    map.put(bizid, map.getordefault(bizid), 0) +1)
            }
        }

