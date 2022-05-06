class Solution {
    
    class Node {
        char ch;
        int freq;
        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Node> stack = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().ch == c) {
                stack.peekLast().freq++; // Increase the frequency
            } else {
                stack.addLast(new Node(c, 1));
            }
            if (stack.peekLast().freq == k) // If reach enough k duplicate letters -> then remove
                stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        for (Node a : stack) {
            sb.append(String.valueOf(a.ch).repeat(a.freq));
        }
        return sb.toString();
        
        
        
//         Brute Force - TLE
//         if(k > s.length()) return s;
//         StringBuilder sb = new StringBuilder(s);
//         int count = 1, i = 0;
//         boolean repeat = false;
//         while(i < sb.length() - 1) {
//             // System.out.println(i);
//             if(sb.charAt(i) == sb.charAt(i + 1)) {
//                 count++;
//                 i++;
//                 if(count == k) {
//                     sb = sb.delete(i + 1 - k, i + 1);
//                     count = 1;
//                     repeat = true;
//                 } 
//             } else {
//                 i++;
//                 count = 1;
//             }
            
//             if(i == sb.length() - 1 && repeat) {
//                 i = 0;
//                 repeat = false;
//             }
//         }
        
//         return sb.toString();
    }
}