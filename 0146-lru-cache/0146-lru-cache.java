class LRUCache {
    class Node {
        int key;
        int val ;
        Node prev; 
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int cap;
    HashMap<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        
        head.next = newNode;
        temp.prev = newNode;
    }

    void deleteNode(Node delNode){
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;

        delPrev.next = delNext ;
        delNext.prev = delPrev;
    }


    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int res = resNode.val;
            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            map.put(key, head.next);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            map.remove(key);
            deleteNode(existingNode);
        }
        if (map.size() == cap) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */