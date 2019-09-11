 class Node {
        
        int data;
        Node next;
        
        public Node reverse(Node head) {
            
            if(head.next == null) {
                return head;
            } 
            
            Node temp = reverse(head.next);
            temp.next = head;
            head.next = null;
            return temp;
        }
 }
