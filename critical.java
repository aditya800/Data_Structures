 
 public static void main(String []args){
        System.out.println("Hello World");
        int[][] roads = new int[3][2];
        roads[0] = new int[] {0,2};
        roads[1] = new int[] {0,1};
        roads[2] = new int[] {0,3};
    
        int n = 3;
        
        List<Integer>[] graph = new ArrayList[n + 1];
        int time = 0;
        boolean[] visited = new boolean[n + 1];
        int[] low = new int[n + 1];
        int[] disc = new int[n + 1];
        int[] parent = new int[n + 1];
        List<List<Integer>> res = new ArrayList();
        
        for(int i=0; i <= n; i++) {
            graph[i] = new ArrayList();
            parent[i] = -1;
            visited[i] = false;
        }
        
        for(int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        for(int i=0; i <= n; i++) {
            if(!visited[i]) {
                dfs(graph, time, i, disc, low, parent, visited, res);
            }
        }
        
        for(List<Integer> l1 : res) {
            if(l1.get(0) > l1.get(1)) {
                int temp = l1.get(0);
                l1.set(0, l1.get(1));
                l1.set(1, temp);
            }
        }
        
        System.out.println(res);
     }
     
     void dfs(List<Integer>[] graph, int time, int u, int[] disc, int[] low, int[] parent, boolean[] visited, List<List<Integer>> res) {
         
         visited[u] = true;
         disc[u] = low[u] = ++time;
         for(int v : graph[u]) {
            if(!visited[v]) {
                parent[v] = u;
                dfs(graph, time, v, disc, low, parent, visited, res);
                low[u] = Math.min(low[u], low[v]);
                if(low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else if(v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
         }
         
     }
