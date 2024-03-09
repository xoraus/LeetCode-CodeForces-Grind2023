class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int idx1 = 0, idx2 = 0;

        while(idx1 < nums1.length && idx2 < nums2.length){
            if(nums1[idx1] == nums2[idx2]){
                return nums1[idx1];
            } else if(nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if(nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                idx1++;
                idx2++;
            }
        }

        return -1;
    }
}