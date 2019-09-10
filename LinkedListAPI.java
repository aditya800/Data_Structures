class Node {
        public int data;
        public Node next;
        public Node prev;
        
        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        
        public Node search(Node head, int key) {
            while(head != null && head.data != key) {
                head = head.next;
            }
            
            return head;
        }
        
        public void addFirst(Node head, Node newNode) {
            
            Node temp = head;
            
            while(head.next != temp) {
                head = head.next;
            }
            
            head.next = newNode;
            newNode.next = temp;
            newNode.prev = head;
            temp.prev = newNode;
             
        }
        
        public void addLast(Node head, Node newNode) {
            
            Node temp = head;
            
            while(head.next != temp) {
                head = head.next;
            }
            
            head.next = newNode;
            newNode.next = temp;
            temp.prev = newNode;
            newNode.prev = head;
            
        }
        
        public void delete(Node head, Node del) {
            
            Node temp = del.prev;
            temp.next = del.next;
            del.next.prev = temp;
            
        }
        
        public Node find_mid(Node head) {
            
            Node temp = head;
            while(temp != null && temp.next != null) {
                temp = temp.next.next;
                head = head.next;
            }
            
            return head; 
            
        }
        
    }
