class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nSet1 = new HashSet<>();
        for(int n: nums1) {
            nSet1.add(n);
        }

        HashSet<Integer> nSet2 = new HashSet<>();
        for(int n: nums2) {
            nSet2.add(n);
        }

        nSet1.retainAll(nSet2);

        int[] res = new int[nSet1.size()];

        int idx = 0;
        for(int n: nSet1) {
            res[idx++] = n;
        }
        return res;

    }
}
