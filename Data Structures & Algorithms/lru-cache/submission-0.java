class LRUCache {
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key, int val, ListNode prev, ListNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
        ListNode(){}
    }
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        setMRU(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            setMRU(node);
        }
        else {
            //evict first
            if(map.size() == capacity) {
                ListNode rem = removeFirst();
                map.remove(rem.key);
            }
            ListNode nn = new ListNode(key, value, null, null);
            map.put(key, nn);
            addLast(nn);
        }
    }

    private void addLast(ListNode node) {
        ListNode prev = tail.prev;

        node.prev = prev;
        node.next = tail;

        prev.next = node;
        tail.prev = node;
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private ListNode removeFirst() {
        ListNode node = head.next;
        remove(node);
        return node;
    }

    private void setMRU(ListNode node) {
        //set node as most recently used. i.e move to top
        remove(node);
        addLast(node);
    }
}
