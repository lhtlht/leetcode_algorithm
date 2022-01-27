package easy;

public class PRO136 {
    public int singleNumber(int[] nums) {
        //异或运算，相同为0，不同为1。 利用异或交换律
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;

    }

    public static void main(String[] args) {
        PRO136 p = new PRO136();
        System.out.println(p.singleNumber(new int[] {2,2,1}));
    }
}
