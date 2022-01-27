package easy;

import java.util.Arrays;

public class PRO31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i=n-1; i>0; i--) {
            if (nums[i] > nums[i-1]){
                Arrays.sort(nums,i,n);
                for (int j=i; j<n; j++){
                    if (nums[j]>nums[i-1]) {
                        int tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
}
