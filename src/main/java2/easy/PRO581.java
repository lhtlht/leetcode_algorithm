package easy;

public class PRO581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE;
        int right = -1;
        int minn = Integer.MAX_VALUE;
        int left = -1;
        for (int i=0; i<n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n-i-1]){
                left = n-i-1;
            } else {
                minn = nums[n-i-1];
            }

        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        PRO581 p = new PRO581();
        System.out.println(p.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15}));
        System.out.println(p.findUnsortedSubarray(new int[] {1,2,3,4}));
    }
}
