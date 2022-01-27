package jz;

public class JZ39 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != res) {
                if (count <= 0){
                    res = nums[i];
                } else {
                    count--;
                }
            } else {
                count++;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        JZ39 j = new JZ39();
        System.out.println(j.majorityElement(new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2})); //2
    }

}
