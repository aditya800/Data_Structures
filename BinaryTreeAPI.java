class Node {
        
        int val;
        Node left;
        Node right;
        
        // no. of edges from root to deepest leaf, runs in N time and lg N space
        public int height(Node root) {
            
            if(root == null)
                return -1;
            // depth of root is 0
        
            return 1 + Math.max(height(root.left), height(root.right));
        }
        
      // T(N) = O(N) and Space = O(h), which can lg N for complete tree or N for skewed tree
        public void inorder(Node root) {
            
            if(root == null) 
                return;
            
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
            
        }
        
        public void preorder(Node root) {
            
            if(root == null) 
                return;
            
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
            
        }
        
        public void postorder(Node root) {
            
            if(root == null) 
                return;
            
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
            
        }
        
        public List<Integer> level_order(Node root) {
            
            List<Integer> l1 = new ArrayList();
            Deque<Node> queue = new LinkedList();
            
            queue.addLast(root);
            
            while(!queue.isEmpty()) {
                
                Node temp = queue.poll();
                l1.add(temp.val);
                queue.addLast(temp.left);
                queue.addLast(temp.right);
                
            }
            return l1;
        }
        
        // T(N) = O(N) and Space = O(h) -> Stack space
       public List<Integer> inorderIterative(TreeNode root) {
        
        Deque<Node> stack = new LinkedList();
        List<Integer> l1 = new ArrayList();
        
        if(root == null)
            return l1;
        
        stack.add(root);
        root = root.left;
        
        while(!stack.isEmpty() || root != null) {
            
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                l1.add(root.val);
                root = root.right;
            }
        }
        
        return l1;
      }
        
    public List<Integer> preorder_iterative(Node root) {
            
        List<Integer> l1 = new ArrayList();
        Deque<Node> stack = new LinkedList();
        
        if(root == null)
            return l1;
        
        while(!stack.isEmpty() || root != null) {
            
            if(root != null) {
                stack.push(root);
                l1.add(root.val);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
            
        }
        
        return l1;
                
     }
        
    public Deque<Integer> topological_order(Node root) {
        Deque<Integer> deque = new LinkedList();
        dfs(root, deque, map);
        return deque;
    }
        
    public void dfs(Node root, Deque<Integer> deque, HashMap<Node, List<Node[]>> map) {
        Node[] edges = map.get(root);
        for(Node edge : edges) {
             dfs(edge, deque, map);
        }
        deque.addFirst(root);
    }
        
    // assuming there is a parent reference
    public Node successor(Node random) {
            
            Node iter = random;
            if(iter.right != null) {
                iter = iter.right;
                while(iter != null) {
                    iter = iter.left;
                }
                return iter;
            }
            
          while(iter.parent != null && iter.parent.left != iter) {
              iter = iter.parent;
          }
         
            return iter.parent;
        }
        
    }
