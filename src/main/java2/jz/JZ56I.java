package jz;

public class JZ56I {
    public int[] singleNumbers(int[] nums) {
        //找到a和b 异或的结果
        int ret = 0;
        for (int i=0; i<nums.length; i++) {
            ret ^= nums[i];
        }

        //找到第一位不为0的位 &运算中1&1=1,1&0=0,0&0=0
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((n&div)==0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[] {a,b};
    }

    public static void main(String[] args) {
        JZ56I j = new JZ56I();
        int[] res = j.singleNumbers(new int[] {4,1,4,6});
        System.out.println(res[0] + ":" + res[1]);

        int[] res1 = j.singleNumbers(new int[] {1,2,10,4,1,4,3,3});
        System.out.println(res1[0] + ":" + res1[1]);
    }
}
