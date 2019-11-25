  public static int minCostPath(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, int x, int y) {

        HashMap<Integer, List<List<Integer>>> graph = new HashMap();
        for(int i = 0; i < gFrom.size(); i++) {
            int a = gFrom.get(i);
            int b = gTo.get(i);
            int w = gWeight.get(i);
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

        int cost = minCost(x, 1, graph) + minCost(y, x, graph) + minCost(gNodes, y, graph);
        return cost;

    }

    public static int minCost(int x, int start, HashMap<Integer, List<List<Integer>>> graph) {
            HashMap<Integer, Integer> map = new HashMap();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
                public int compare(Integer node1, Integer node2) {
                    return Integer.compare(map.get(node1), map.get(node2));
                }     
            });
            map.put(start, 0);
            pq.add(start);
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
            return map.get(x);
    }
