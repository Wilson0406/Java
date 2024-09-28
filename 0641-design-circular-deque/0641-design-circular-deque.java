class MyCircularDeque {
    
    int[] dq;
    int size, back, front, capacity;
    public MyCircularDeque(int k) {
        dq = new int[k];
        Arrays.fill(dq, -1);
        size = 0;
        capacity = k;
        front = 0;
        back = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }
        dq[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        dq[back] = value;
        if(back == capacity - 1) {
            back = 0;
        } else {
            back++;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        dq[front] = -1;
        if(front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        
        
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        
        
        if(back == 0) {
            back = capacity - 1;
        } else {
            back--;
        }
        dq[back] = -1;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return dq[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        if(back == 0) {
            return dq[capacity - 1];
        } else {
            return dq[back - 1];
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
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