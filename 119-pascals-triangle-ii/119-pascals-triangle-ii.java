import java.math.BigInteger;
class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        int len = rowIndex + 1;
        List<Integer> res = new ArrayList<>(len);
        // res.add(1);
        if(rowIndex == 0) {
            res.add(1);
            return res;
        }
//         int half = len / 2, i = 0;
        
        
//         for(i = 0; i < half; i++) {
//             res.add(getVal(rowIndex, i));
//         }
        
//         // System.out.println(res);

//         if((len & 1) == 1) {
//             res.add(getVal(rowIndex, half));
//             half = half + 1;
//         }
            
        
//         // System.out.println(half);

//         for(i = half; i < len; i++) {
//             res.add(res.get(rowIndex - i));
//         }
        
//         // res.add(1);
        
        res.add(1);
        long curr = 1, nume = rowIndex, deno = 1;
        for(int i = 1; i <= rowIndex; i++, deno++, nume--) {
            curr = (curr * nume) / deno;
            res.add((int)curr);
        }
        // res.add(1);
        return res;
    }
    
    private int getVal(int n, int r) {
        if(r == 0 || r == n) return 1;
        if(n - r == 1) return n;
        
        r = n - r > r ? r : n - r;
        System.out.println("n: " + n + " r : " + r);
        
//         long nume = n;
//         for(int i = 1; i < r; i++) {
//             nume *= --n;
//         }
        
//         System.out.println("Numerator: " + nume);
        
//         long deno = r;
//         for(int i = r - 1; i > 0; i--) {
//             deno *= i;
//         }
        
        BigInteger nume = BigInteger.valueOf(n);
        BigInteger deno = BigInteger.valueOf(r);
        for(int i = r - 1; i > 0; i++) {
            nume = nume.multiply(BigInteger.valueOf(--n));
            deno = deno.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println("Denominator: " + deno);
        
        int res = nume.divide(deno).intValue();
        
        System.out.println("Curr Combination: " + res);
        
        return res;
    }
        
}