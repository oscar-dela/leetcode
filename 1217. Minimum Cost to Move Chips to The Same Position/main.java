class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;

        for(int p: position) {
            if(p%2==1) {
                odd++;
            }else{
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
