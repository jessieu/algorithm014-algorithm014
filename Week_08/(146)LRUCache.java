/**
 * Use doubly linked list and hash map
 * DLL is easy for oldest element removal
 * Hash Map map key to ListNode
 */
class LRUCache {
    private ListNode head, tail;
    private HashMap<Integer, ListNode> cache;
    private int size;
    private int capacity;56

    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;
    }

    // always add node to front
    private void addNode(ListNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addNode(node);
    }

    private ListNode removeTail() {
        ListNode temp = tail.prev;
        removeNode(temp);
        return temp;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();

        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode current = cache.get(key);
        if (current == null) return -1;
        moveToHead(current);
        return current.value;
    }

    public void put(int key, int value) {
        ListNode current = cache.get(key);
        if (current == null) {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);
            size++;

            if (size > capacity) {
                ListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            current.value = value;
            moveToHead(current);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */