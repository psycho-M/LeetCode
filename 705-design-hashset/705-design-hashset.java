class MyHashSet {
    
    int[] set;
    int limit = 1000001;
    public MyHashSet() {
        set = new int[limit];
    }
    
    public void add(int key) {
        if(set[key] == 0) set[key] = 1;
    }
    
    public void remove(int key) {
        if(set[key] == 1) set[key] = 0;
    }
    
    public boolean contains(int key) {
        if(set[key] == 1) return true;
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */