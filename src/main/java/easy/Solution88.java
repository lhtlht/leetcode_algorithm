package easy;

public class Solution88 {
    /*
    88. 合并两个有序数组
    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。



    说明:

    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。


    示例:

    输入:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    输出: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        if (j >= 0) {
            for (int t = 0; t<=j; t++) {
                nums1[t] = nums2[t];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Solution88 s = new Solution88();
        s.merge(nums1,3,nums2,3);
        for (int m : nums1) {
            System.out.print(m + " ");
        }
        System.out.println();
        int[] n1 = {0};
        int[] n2 = {1};
        s.merge(n1,0,n2,1);
        for (int m : n1) {
            System.out.print(m + " ");
        }
    }
}
