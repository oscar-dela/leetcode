class Solution {
    private int[] days, costs;
    private Integer[] memo;
    private int[] duration = new int[]{1, 7, 30};
    
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        
        return dp(0);
    }

    private int dp(int di) {
        if(di >= days.length) {
            return 0;
        }
        if(memo[di] != null) {
            return memo[di];
        }
        
        int j = di;
        
        int res = Integer.MAX_VALUE;
        for(int k=0; k<duration.length; k++) {
            while(j<days.length && days[j] < days[di] + duration[k]) {
                j++;
            }
            res = Math.min(res, dp(j) + costs[k]);
        }
        memo[di] = res;
        return res;
    }
}
