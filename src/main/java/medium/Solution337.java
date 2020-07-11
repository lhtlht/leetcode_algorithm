package medium;

import ht_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution337 {

    Map<TreeNode, Integer> memory = new HashMap<TreeNode, Integer>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memory.containsKey(root)) return memory.get(root);

        //抢
        int yesRob = root.value +
                (root.left == null? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right==null? 0 : rob(root.right.left) + rob(root.right.right));
        //不抢
        int noRob = rob(root.left) + rob(root.right);
        int res = Math.max(yesRob,noRob);
        memory.put(root, res);
        return res;
    }


    public static void main(String[] args) {

    }
}
