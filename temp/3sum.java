class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> set = new HashSet();
        List<List<Integer>> l1 = new ArrayList();

        if(nums.length < 3)
            return l1;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            
               if(i > 0 && nums[i] == nums[i-1])
                   continue;
            
               int target = -nums[i];
               int j = i + 1;
               int k = nums.length - 1;
            
               while(j < k) {
                   
                   int tempSum = nums[j] + nums[k];
                   if(tempSum == target) {
                       List<Integer> l2 = Arrays.asList(nums[i], nums[j], nums[k]);
                       if(!set.contains(l2)) {
                            set.add(l2);
                       }
                       j++;
                       k--;
                   } else if(tempSum < target) {
                       j++;
                   } else {
                       k--;
                   }
               }
        }
        
        l1.addAll(set);
        return l1;
    }
}
