class Solution {
    public int[] movesToStamp(String S, String T) {
        if (S.equals(T)) return new int[]{0};
        char[] sChar = S.toCharArray(), tChar = T.toCharArray();
        int slen = sChar.length, tlen = tChar.length - slen + 1, i, j;
        List<Integer> lans = new ArrayList<>();
        Boolean tdiff = true, sdiff;
        while (tdiff)
            for (i = 0, tdiff = false; i < tlen; i++) {
                for (j = 0, sdiff = false; j < slen; j++)
                    if (tChar[i+j] == '*') continue;
                    else if (tChar[i+j] != sChar[j]) break;
                    else sdiff = true;
                if (j == slen && sdiff) {
                    for (j = i, tdiff = true; j < slen + i; j++)
                        tChar[j] = '*';
                    lans.add(i);
                }
            }
        for (i = 0; i < tChar.length; i++) if (tChar[i] != '*') return new int[]{};
        int[] res = new int[lans.size()];
        Collections.reverse(lans);
        for (i = 0; i < lans.size(); i++) res[i] = lans.get(i);
        return res;
    }
}