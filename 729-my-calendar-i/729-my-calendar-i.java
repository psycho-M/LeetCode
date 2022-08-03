class MyCalendar {
    
    TreeMap<Integer, Integer> cal = new TreeMap<>();
    
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if(cal.containsKey(start)) return false;
        // cal.put(start, end);
        end--;
        Integer left = cal.floorKey(start);
        // System.out.println(cal);
        if(left != null && start >= left && start <= cal.get(left)) {
            return false;
        }
        Integer right = cal.ceilingKey(start);
        if(right != null && end >= right) return false;
        cal.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */