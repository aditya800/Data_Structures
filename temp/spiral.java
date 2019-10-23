class Solution {
    public int[][] generateMatrix(int n) {
        
        if(n < 1) 
            return new int[][] {};
        
        int[][] matrix = new int[n][n];
        int currentElem = 1, top = 0, left = 0, bottom = n-1, right = n-1, dir = 0;
        
        while(top <= bottom && left <= right) {
            
            if(dir == 0) {
                for(int i=left; i<=right; i++)
                    matrix[top][i] = currentElem++;
                top++;
                dir = 1;
            } else if(dir == 1) {
                for(int i=top; i<=bottom; i++)
                    matrix[i][right] = currentElem++;
                right--;
                dir = 2;
            } else if(dir == 2) {
                for(int i=right; i>=left; i--)
                    matrix[bottom][i] = currentElem++;
                bottom--;
                dir = 3;
            } else if(dir == 3) {
                for(int i=bottom; i>=top; i--)
                    matrix[i][left] = currentElem++;
                left++;
                dir = 0;
            }
            
        }
        
            return matrix;
    }
}
