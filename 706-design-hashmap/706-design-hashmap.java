class MyHashMap {
    int[] arr = new int[1000001];
    public MyHashMap() {
    }
    
    public void put(int key, int value) {
        arr[key] = value + 1;
    }
    
    public int get(int key) {
        return arr[key] - 1;
    }
    
    public void remove(int key) {
        arr[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */