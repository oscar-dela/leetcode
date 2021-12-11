class Node {
    private Node next;
    private Node prev;
    private int val;
    private int key;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }     

    public void setNext(Node next) {
        this.next = next;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
    public Node getPrev() {
        return this.prev;
    }
    
    public int getVal() {
        return this.val;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map = new HashMap<>();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.tail = new Node(-1, -1);
        this.head = new Node(-1, -1);
        head.setNext(tail);
        tail.setPrev(head);
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node cur = map.get(key);
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
            updateToHead(cur);
            return cur.getVal();
        } else {
            return -1;
        }
    }
    
    private void purge() {
        Node removeNode = tail.getPrev();
        removeNode.getPrev().setNext(removeNode.getNext());
        removeNode.getNext().setPrev(removeNode.getPrev());
        map.remove(removeNode.getKey());
        capacity++;
    }
    
    private void updateToHead(Node n) {
        n.setNext(head.getNext());
        
        head.getNext().setPrev(n);
        head.setNext(n);
        
        head.setNext(n);
        n.setPrev(head);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
            updateToHead(cur);
            cur.setVal(value);
        }else {
            if (capacity - 1 < 0) purge();
            
            Node n = new Node(key, value);
            updateToHead(n);

            map.put(key, n);
            capacity--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
