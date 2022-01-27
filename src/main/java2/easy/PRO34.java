package easy;

public class PRO34 {

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int res = 0;
        int[] dp = {-1,-1};
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                dp[0] = mid;
                dp[1] = mid;
                res = mid;
                break;
            }
            if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        int dpn = res-1;
        while (dpn>=0 && nums[dpn] == target ) {
            dp[0] = dpn;
            dpn--;
        }
        dpn = res+1;
        while (dpn < nums.length && nums[dpn] == target ) {
            dp[1] = dpn;
            dpn++;
        }
        return dp;
    }

    public static void main(String[] args) {
        PRO34 p = new PRO34();
        int[] d = {5,7,7,8,8,10};
        int[] res = p.searchRange(d, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
