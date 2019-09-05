class Solution {
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length < 1 || grid[0].length < 1)
            return 0;        
        
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int total = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                
                int tempislands = 0;
                Queue<int[]> q = new LinkedList();
                
                if(grid[i][j] != '0') {
                    q.add(new int[] {i, j});
                    tempislands = 1;
                }
                
                while(!q.isEmpty()) {
                    
                    int[] a = q.poll();
                    if(grid[a[0]][a[1]] != '0') {
                        
                          grid[a[0]][a[1]] = '0';
                          
                          for(int[] dir : dirs) {
                              int[] b = new int[] {a[0] + dir[0], a[1] + dir[1]};
                              if(b[0] >= 0 && b[0] < grid.length && b[1] >= 0 && b[1] < grid[b[0]].length && grid[b[0]][b[1]] == '1') {
                                  q.add(b);
                              }
                          }
                        
                    }
                    
                }
                
                total += tempislands;
                
            }
        }
        
        return total;
    }

}
