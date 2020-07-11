package hard;

import java.util.HashMap;
import java.util.Map;

public class Solution887 {
    /**
     * 887. 鸡蛋掉落
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     *
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     *
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     *
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     *
     * 你的目标是确切地知道 F 的值是多少。
     *
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     *
     *
     *
     * 示例 1：
     *
     * 输入：K = 1, N = 2
     * 输出：2
     * 解释：
     * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
     * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
     * 如果它没碎，那么我们肯定知道 F = 2 。
     * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
     * 示例 2：
     *
     * 输入：K = 2, N = 6
     * 输出：3
     * 示例 3：
     *
     * 输入：K = 3, N = 14
     * 输出：4
     *
     * @param K
     * @param N
     * @return
     */
    Map<String, Integer> memo = new HashMap<String, Integer>();
    public int superEggDrop(int K, int N) {
        //状态：鸡蛋数K，楼层N
        //选择：去哪层扔鸡蛋
        return dp(K,N);

    }

    public int dp(int K, int N) {
        if (K == 1) return N;
        if (N == 0) return 0;
        if (memo.containsKey(K+"_"+N)) {
            return memo.get(K+"_"+N);
        }
        int res = Integer.MAX_VALUE;
        //穷举所有的可能
        for (int i=1; i<N+1; i++) {
            res = Math.min(res,
                    Math.max(
                            dp(K,N-i),
                            dp(K-1,i-1)
                    )+1
            );
        }
        memo.put(K+"_"+N, res);
        return res;

    }

    public static void main(String[] args) {
        int K = 2, N = 6;
        int K1 = 3, N1 = 14;


        Solution887 s = new Solution887();
        System.out.println(s.superEggDrop(K,N)); //3
        System.out.println(s.superEggDrop(K1,N1)); //4
    }

}
