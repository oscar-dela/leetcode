class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int s1L = s1.length();
        
        for(int i=0; i < s1L; i++) {
            cnt1[s1.charAt(i)-'a']++;
        }
        
        for(int i=0; i < s2.length(); i++) {
            cnt2[s2.charAt(i)-'a']++;
            if(i >= s1L) cnt2[s2.charAt(i-s1L)-'a']--;
            if(Arrays.equals(cnt2, cnt1)) return true;
        }
        return false;
    }
}
