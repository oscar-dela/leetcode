class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> res = new ArrayList<>();

        int i1 = 0, i2 = 0;
        
        while(i1 < nums1.length && i2 < nums2.length) {
            if(nums1[i1] == nums2[i2]) {
                res.add(nums1[i1]);
                i1++;
                i2++;
            } 
            else if (nums1[i1] > nums2[i2]) i2++;
            else i1++;
        }
        int[] r = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            r[i] = res.get(i);
        }
        
        return r;
    }
}
