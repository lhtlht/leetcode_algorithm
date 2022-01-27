package jz;

public class JZ21 {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i <= j) {
            while (i <= j && nums[i]%2 != 0) {
                i++;
            }
            while (i <= j && nums[j]%2 == 0) {
                j--;
            }
            if (i > j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;


        }
        return nums;
    }

    public static void main(String[] args) {
        JZ21 j = new JZ21();
        System.out.println(j.exchange(new int[] {1,2,3,4}));
    }
}
