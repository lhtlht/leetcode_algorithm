package medium;

public class Solution96 {
    /*
    96. 不同的二叉搜索树
    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

    示例:

    输入: 3
    输出: 5
    解释:
    给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
     */

    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for (int i=2; i<=n; i++) { //节点个数
            for (int j=1; j<=i; j++) { //根节点
                g[i] += g[j-1] * g[i-j];
            }
        }
        return g[n];
    }

    public static void main(String[] args) {
        Solution96 s = new Solution96();
        System.out.println(s.numTrees(3)); //5
    }
}
