class Solution {
    public int calPoints(String[] ops) {
        if(ops.length == 1) return Integer.parseInt(ops[0]);
        List<Integer> res = new ArrayList<>(ops.length);
        String c = "C", d = "D", p = "+";
        for(String s : ops) {
            int i = res.size() - 1;
            if(s.equals(c)) res.remove(i);
            else if(s.equals(d)) res.add(res.get(i) * 2);
            else if(s.equals(p)) res.add(res.get(i) + res.get(i - 1));
            else res.add(Integer.parseInt(s));
        }
        int sum = 0;
        for(int n : res) sum += n;
        return sum;
    }
}