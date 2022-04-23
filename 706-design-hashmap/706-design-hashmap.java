class MyHashMap {
    
    // int[] map;
    Node[] map;
    
    public MyHashMap() {
        // map = new int[1000001];
        // Arrays.fill(map, -1);
        map = new Node[10000];
    }
    
    int getIndex(int key) {
        return Integer.hashCode(key) % map.length;
    }
    
    Node findElement(int index, int key) {
        if(map[index] == null) return map[index] = new Node(-1, -1);
        Node prev = map[index];
        
        while(prev.next != null && prev.next.key != key) prev = prev.next;
        return prev;
    }
    
    public void put(int key, int val) {
        // map[key] = value;
        int index = getIndex(key);
        Node prev = findElement(index, key);
        
        if(prev.next == null) prev.next = new Node(key, val);
        else prev.next.val = val;
    }
    
    public int get(int key) {
        // return map[key];
        int index = getIndex(key);
        Node prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        // map[key] = -1;
        int index = getIndex(key);
        Node prev = findElement(index, key);
        
        if(prev.next != null) prev.next = prev.next.next;
    }
}

class Node {
    int key, val;
    Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */