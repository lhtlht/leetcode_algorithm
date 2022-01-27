package medium;

public class Solution338 {
    /*
    338. 比特位计数
    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

    示例 1:

    输入: 2
    输出: [0,1,1]
    示例 2:

    输入: 5
    输出: [0,1,1,2,1,2]
     */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i=1; i<=num; i++) {
            res[i] = popcount(i);
        }
        return res;
    }

    public int popcount(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num-1); //总是把num的最后一个1转化为0
            count++;
        }
        return count;
    }


    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        int k = 1;
        int i = 1;
        while (i <= num) {
            for (int j=0; j<k; j++) {
                if (i <= num) {
                    res[i++] = res[j] + 1;
                } else {
                    break;
                }
            }
            k *= 2;
        }
        return res;
    }
}
