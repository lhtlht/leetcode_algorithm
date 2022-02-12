package easy;

public class PRO88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        while (p >= 0 && n > 0 && m > 0) {
            if (nums1[m-1] >= nums2[n-1]) {
                nums1[p] = nums1[m-1];
                m--;
            } else {
                nums1[p] = nums2[n-1];
                n--;
            }
            p--;
        }
        while (p >= 0 && n >0) {
            nums1[p] = nums2[n-1];
            n--;
            p--;
        }
    }

    public static void main(String[] args) {
        PRO88 p = new PRO88();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        p.merge(nums1,3, nums2, 3);
        for (int num: nums1) {
            System.out.println(num);
        }
        System.out.println("------------");
        int[] nums3 = {0};
        int[] nums4 = {1};
        p.merge(nums3,0, nums4, 1);
        for (int num: nums3) {
            System.out.println(num);
        }

    }
}
