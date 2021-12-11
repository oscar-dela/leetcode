class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> loc = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            if(!loc.containsKey(nums[i])) {
                loc.put(nums[i], new ArrayList<>());
            }
            loc.get(nums[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> e: loc.entrySet()) {
            int t = target - e.getKey();
            if(loc.containsKey(t)) {
                if(t != e.getKey()) {
                    return new int[]{e.getValue().get(0), loc.get(t).get(0)};
                } 
                if(e.getValue().size() >= 2) {
                    return new int[]{e.getValue().get(0), e.getValue().get(1)};
                }
            } 
        }
        return new int[0];
    }
}
