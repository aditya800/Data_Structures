public static int findBestCity(int distanceThreshold, int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, List<Integer> cityWeight) {
        
        HashMap<Integer, List<List<Integer>>> graph = new HashMap();
        for(int i = 0; i < cityFrom.size(); i++) {
            int a = cityFrom.get(i);
            int b = cityTo.get(i);
            int w = cityWeight.get(i);
            List<Integer> l1 = Arrays.asList(b, w);
            List<Integer> l2 = Arrays.asList(a, w);
            if(!graph.containsKey(a)) {
                graph.put(a, new ArrayList());
            }
            graph.get(a).add(l1);
            if(!graph.containsKey(b)) {
                graph.put(b, new ArrayList());
            }
            graph.get(b).add(l2);
        }
        
        int min = Integer.MAX_VALUE;
        int res = 1;
        for(int i = 1; i <= cityNodes; i++) {
            HashMap<Integer, Integer> map = new HashMap();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
                public int compare(Integer node1, Integer node2) {
                    return Integer.compare(map.get(node1), map.get(node2));
                }     
            });
            map.put(i, 0);
            pq.add(i);
            while(!pq.isEmpty()) {
                int cur = pq.poll();
                List<List<Integer>> neighbors = graph.get(cur);
                for(List<Integer> l1 : neighbors) {
                    if(!map.containsKey(l1.get(0)) || map.get(cur) + l1.get(1) < map.get(l1.get(0))) {
                        map.put(l1.get(0), map.get(cur) + l1.get(1));
                        pq.add(l1.get(0));
                    }
                }
            }
            int neigh = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() != i && entry.getValue() <= distanceThreshold) {
                    neigh++;
                }
            }
            if(neigh <= min) {
                res = i;
                min = neigh;
            }
        }
        return res;
    }
