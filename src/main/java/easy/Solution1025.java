package easy;

public class Solution1025 {
    /*
    1025. 除数博弈
    爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

    最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

    选出任一 x，满足 0 < x < N 且 N % x == 0 。
    用 N - x 替换黑板上的数字 N 。
    如果玩家无法执行这些操作，就会输掉游戏。

    只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
     */

    public boolean divisorGame(int N) {
        return N%2 == 0 ? true:false;
    }

    public static void main(String[] args) {
        Solution1025 s = new Solution1025();
        System.out.println(s.divisorGame(2)); //true
        System.out.println(s.divisorGame(3)); //false
    }
}
