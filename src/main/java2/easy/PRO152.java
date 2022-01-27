package easy;

public class PRO152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] minDp = new int[n];
        int[] maxDp = new int[n];
        minDp[0] = nums[0];
        maxDp[0] = nums[0];
        int res = nums[0];
        for (int i=1; i<n; i++) {
            minDp[i] = Math.min(Math.min(minDp[i-1]*nums[i], maxDp[i-1]*nums[i]), nums[i]);
            maxDp[i] = Math.max(Math.max(minDp[i-1]*nums[i], maxDp[i-1]*nums[i]), nums[i]);
            res = Math.max(maxDp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        PRO152 p = new PRO152();
        System.out.println(p.maxProduct(new int[] {-2,3,-4}));
    }
}
