package jz;

public class JZ03 {
    public int findRepeatNumber(int[] nums) {
        int[] copy = new int[nums.length];
        for(int num: nums) {
            copy[num] ++;
            if (copy[num] > 1){
                return num;
            }
        }
        return 0;
    }


}
