package easy;

public class PRO213 {
    public int rob(int[] nums) {
        //首尾不能同时偷
        //首不偷或者尾不偷
        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }
        int isRob = nums[0];
        int isNotRob = 0;
        int tmp;
        for(int i=1; i<len-1; i++) {
            tmp = Math.max(isRob,isNotRob); //不偷
            isRob = isNotRob + nums[i];
            isNotRob = tmp;
        }
        int res1 = Math.max(isRob,isNotRob);

        isRob = nums[1];
        isNotRob = 0;
        for (int i=2; i<len; i++) {
            tmp = Math.max(isRob,isNotRob); //不偷
            isRob = isNotRob + nums[i];
            isNotRob = tmp;
        }
        int res2 = Math.max(isRob,isNotRob);
        return Math.max(res1,res2);

    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        PRO213 p = new PRO213();
        System.out.println(p.rob(nums));
    }
}
