public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make sure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            
            // Handle edge cases
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // We have found the correct partition
                if ((m + n) % 2 == 0) {
                    // Even length: median is the average of the max of left and min of right
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // Odd length: median is the max of the left partition
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move the partition in nums1 to the left
                high = partition1 - 1;
            } else {
                // Move the partition in nums1 to the right
                low = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println("Median: " + findMedianSortedArrays(nums1_2, nums2_2)); // Output: 2.5
    }
}
