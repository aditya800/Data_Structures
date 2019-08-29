class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> A = new ArrayList();
        for(int j : nums) {A.add(j);}
        
        List<List<Integer>> result = new ArrayList();
        
        directedPermutations(0, A, result);
        
        return result;
        
    }
    
     static void directedPermutations(int i, List<Integer> A, List<List<Integer>> result) {
        
        if(i == A.size() - 1) {
            result.add(new ArrayList<>(A));
        }
        
        for(int j = i; j<A.size(); j++) {
            Collections.swap(A, i, j);
            directedPermutations(i + 1, A, result);
            Collections.swap(A, i, j);
        }
        
    }
    
}
