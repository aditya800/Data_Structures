class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    
    public boolean traverse(TreeNode s, TreeNode t) {
        
        if(s == null)
            return false;
        
        return equals(s,t) || traverse(s.left, t) || traverse(s.right, t);
        
    }
    
    public boolean equals(TreeNode s, TreeNode t) {
        
        if(s == null && t == null)
            return true;
        
        if(s == null || t == null)
            return false;
        
        return (s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right));
        
    }
    
}
