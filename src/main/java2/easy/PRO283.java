package easy;

public class PRO283 {
    public void moveZeroes(int[] nums) {
        int p = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        while (p < nums.length) {
            nums[p] = 0;
            p++;
        }
    }

    public static void main(String[] args) {
        PRO283 p = new PRO283();
        int[] nums = {0,1,0,3,12};
        p.moveZeroes(nums);
        System.out.println("--------------");
        for(int num : nums) {
            System.out.println(num);
        }
    }
}
