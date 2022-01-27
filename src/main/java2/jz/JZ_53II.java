package jz;

public class JZ_53II {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            if(nums[mid] == mid) {
                left = mid + 1;
            } else if(nums[mid] > mid) {
                right = mid - 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        JZ_53II j = new JZ_53II();
        System.out.println(j.missingNumber(new int[] {0,1,3})); //2
        System.out.println(j.missingNumber(new int[] {0,1,2,3,4,5,6,7,9}));
        System.out.println(j.missingNumber(new int[] {0}));
    }
}
