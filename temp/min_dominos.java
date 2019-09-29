class Solution {
    
    public int minDominoRotations(int[] A, int[] B) {
        int r1 = computeMinSwaps(A, B, A[0]);
        if(r1 != -1 || A[0] == B[0])
            return r1;
        return computeMinSwaps(A, B, B[0]);
    }
    
    public int computeMinSwaps(int[] A, int[] B, int elem) {
        
        int i1 = 0, i2 = 0;
        
        for(int i=0; i < A.length;i++) {
            
            if(A[i] != elem && B[i] != elem)
                return -1;
            else if(A[i] != elem)
                i1++;
            else if(B[i] != elem)
                i2++;
            
        }
        
        return Math.min(i1, i2);
        
    }
}
