package easy;

public class PRO238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1; i<nums.length; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        int p = 1;
        for (int i=nums.length-2; i>=0; i--) {
            res[i] = res[i] * p * nums[i+1];
            p = p * nums[i+1];
        }
        return res;
    }

    public static void main(String[] args) {
        PRO238 p = new PRO238();
        int[] nums = {1,2,3,4};
        int[] res = p.productExceptSelf(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
