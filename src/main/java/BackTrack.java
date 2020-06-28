import java.util.LinkedList;
import java.util.List;

public class BackTrack {
    /**
     回溯算法基本框架：
     result = []
     def backtrack(路径, 选择列表):
        if 满足结束条件:
            result.add(路径)
        return

        for 选择 in 选择列表:
            做选择
            backtrack(路径, 选择列表)
            撤销选择



     */
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        //记录每一条路径
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(nums, track);
        return res;
    }
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (track.contains(nums[i])) continue;
            //做选择
            track.add(nums[i]);
            // 进入下一个决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();



        }
    }



    //N皇后

    /**
     给你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击。
     PS：皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
     */
    //n * n的棋盘
    List<List<String>> ress = new LinkedList<List<String>>();
    public List<List<String>> nQueen(int n) {
        List<String> bord = new LinkedList<String>();
        for (int i=0; i<n; i++) bord.add(".");
        nQueenBackTrack(bord, 0);
        return ress;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    public void nQueenBackTrack(List<String> bord, int row) {
        if (row == bord.size()) {
            ress.add(bord);
            
            return;
        }

        for (int col=0; col<bord.size(); col++) {
            if(!isValid(bord, row, col)) continue;
            //做选择



        }


    }

    public boolean isValid(List<String> bord, int row, int col) {
        return true;
    }




    public static void main(String[] args) {
        //全排列 输入一组不重复的数字
        int[] nums = {1,2,3};
        BackTrack s = new BackTrack();
        List<List<Integer>> r = s.permute(nums);
        System.out.println(r);



        //N皇后


    }



}
