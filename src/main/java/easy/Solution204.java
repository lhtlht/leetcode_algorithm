package easy;

import java.util.Arrays;

public class Solution204 {
    /**
     * 204. 计数质数
     * 统计所有小于非负整数 n 的质数的数量
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for (int i=2; i*i<n; i++) {
            if (isPrimes[i]) {
                for (int j=i*i; j<n; j+=i) {
                    isPrimes[j] = false;
                }
            }
        }

        for (int i=2; i<n; i++) {
            res += isPrimes[i]?1:0;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 10;
        Solution204 sol = new Solution204();
        System.out.println(sol.countPrimes(n)); //4
    }

}
