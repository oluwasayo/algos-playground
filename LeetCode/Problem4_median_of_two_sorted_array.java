public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int preHalf = 0, half = 0;
        int p1 = 0, p2 = 0, count = 0;
        double result = 0.0;
        while (p1 < nums1.length || p2 < nums2.length) {
            if (p2 >= nums2.length || (p1 < nums1.length && nums1[p1] <= nums2[p2])) {
                preHalf = half; half = nums1[p1];
                p1++;
            } else {
                preHalf = half; half = nums2[p2];
                p2++;
            }

            if (totalLength / 2 == count) {
                if (totalLength % 2 == 0) {
                    result =  (half + preHalf) / 2.0;
                } else {
                    result = half;
                }
            }
            count++;
        }
        return result;
    }
}