class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> res =  new LinkedList<>();
        
        for(int[] interval: intervals) {
            if(res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.add(interval);
            } else {
                res.getLast()[1] = Math.max(interval[1], res.getLast()[1]); 
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
