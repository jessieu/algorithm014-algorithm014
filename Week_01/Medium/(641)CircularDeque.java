class MyCircularDeque {
    private int[] queue; // circular array
    private int capacity;
    private int front;
    private int last;
    private int counts;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k];
        capacity = k;
        front = -1;
        last = 0;
        counts = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }

        // front = ((front - 1) % capacity + capacity) % capacity;
        queue[front] = value;

        counts++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            front = 0;
        } else if (last == capacity-1) {
            last = 0;
        } else {
            last++;
        }
        // need to check whether it is full or not before add
        // last = (last + 1) % capacity;
        queue[last] = value;

        counts++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        // update front index
        if (front == last) { // last item
            front = -1;
            last = 0;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }

        counts--;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        if (front == last) {
            front = -1;
            last = 0;
        } else if (last == 0) {
            last = capacity - 1;
        } else {
            last--;
        }
        counts--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return queue[last];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return counts == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return counts == capacity;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */