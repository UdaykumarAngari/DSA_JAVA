class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Dummy head and tail
    // head side = most recently used
    // tail side = least recently used
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int cap;

    // key -> Node
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;

        // Initially list is empty:
        // head <-> tail
        head.next = tail;
        tail.prev = head;
    }

    // Add node right after head
    // This makes it most recently used
    void addNode(Node newNode) {
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    // Delete a node from its current position
    void deleteNode(Node delNode) {
        Node prevNode = delNode.prev;
        Node nextNode = delNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {

        if(map.containsKey(key)) {

            // map.get(key) returns the Node
            Node resNode = map.get(key);

            int value = resNode.val;

            // Since it is accessed now,
            // move it to most recently used position
            deleteNode(resNode);
            addNode(resNode);

            return value;
        }

        return -1;
    }

    public void put(int key, int value) {

        // If key already exists,
        // remove old node first
        if(map.containsKey(key)) {
            Node existingNode = map.get(key);
            deleteNode(existingNode);
            map.remove(key);
        }

        // If cache is full,
        // remove least recently used node
        if(map.size() == cap) {
            Node lru = tail.prev;

            deleteNode(lru);
            map.remove(lru.key);
        }

        // Insert new node as most recently used
        Node newNode = new Node(key, value);

        addNode(newNode);
        map.put(key, newNode);
    }
}