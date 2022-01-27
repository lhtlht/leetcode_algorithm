package easy;

public class PRO33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                //有序
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                //无序
                if (nums[mid] < target && target <= nums[nums.length-1]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }


        }
        return -1;
    }


}
