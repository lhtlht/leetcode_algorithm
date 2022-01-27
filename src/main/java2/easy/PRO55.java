package easy;

public class PRO55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int re = nums[0];
        for (int i=1; i<n; i++) {
            re--;
            if(re < 0) {
                return false;
            }
            re = Math.max(re, nums[i]);
            if (re == 0 && i!=n-1) {
                return false;
            }
            if (re >= n-1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PRO55 p = new PRO55();
        System.out.println(p.canJump(new int[] {2,3,1,1,4}));
        System.out.println(p.canJump(new int[] {3,2,1,0,4}));
        System.out.println(p.canJump(new int[] {0,1}));
    }
}
