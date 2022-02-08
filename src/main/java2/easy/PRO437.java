package easy;

import ht_tree.TreeNode;
import jdk.nashorn.internal.ir.SplitReturn;

import java.util.HashMap;
import java.util.Map;

public class PRO437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0,1);
        return rePathSum(root, preSum, targetSum, 0);
    }

    private int rePathSum(TreeNode node, Map<Integer, Integer> preSum, int target, int currSum) {
        if (node == null) return 0;
        int res = 0;
        currSum += node.value;
        res += preSum.getOrDefault(currSum-target,0);
        preSum.put(currSum, preSum.getOrDefault(currSum,0)+1);

        res += rePathSum(node.left, preSum, target, currSum);
        res += rePathSum(node.right, preSum, target, currSum);
        preSum.put(currSum, preSum.getOrDefault(currSum,0)-1);
        return res;

    }
}
