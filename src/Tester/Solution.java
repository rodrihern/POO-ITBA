package Tester;

public abstract class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        // merging the arrays
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else if(nums1[i] > nums2[j]) {
                merged[k++] = nums2[j++];
            } else {
                merged[k++] = nums1[i++];
                merged[k++] = nums2[j++];
            }
        }
        while(i < nums1.length) {
            merged[k++] = nums1[i++];
        }
        while(j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        return k%2 == 0 ? (merged[k/2] + merged[k/2 - 1]) / 2.0 : merged[k/2];

    }
}
