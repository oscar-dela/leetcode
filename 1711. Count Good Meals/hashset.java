class Solution {
    public int countPairs(int[] d) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long res=0, mod = (long)1e9+7;
        for(int v: d) {
            int pow = 1;
            for(int i=0; i<22; i++) {       // due to 0 <= deliciousness[i] <= 220
                if(cnt.containsKey(pow-v)) {
                    res += cnt.get(pow-v);
                    res %= mod;
                }
                pow *= 2;
            }
            cnt.put(v, cnt.getOrDefault(v, 0)+1);
        }
        return (int)res;
    }
}
