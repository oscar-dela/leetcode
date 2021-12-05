class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int res=0, i=0, maxDay=events.length;
        
        for(int d=0; d<=100*1000; d++){
            while(!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            
            while(i < maxDay && events[i][0] == d) {
                pq.offer(events[i++][1]);
            }

            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
        }    
        return res;    
    }
}
