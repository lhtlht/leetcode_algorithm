package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution987 {
    /*
    给定二叉树，按垂序遍历返回其结点值。

    对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。

    把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。

    如果两个结点位置相同，则首先报告的结点值较小。

    按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList<Location>();
        dfs(root, 0, 0); //假设根节点（0,0）
        Collections.sort(locations);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int prev = locations.get(0).x;
        for (Location location : locations) {
            if (location.x != prev) {
                prev = location.x;
                ans.add(new ArrayList<Integer>());
            }

            // We always add the node's value to the latest report.
            ans.get(ans.size() - 1).add(location.val);
        }
        return ans;
    }

    public void dfs(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        //前序
        locations.add(new Location(x,y,node.val));
        dfs(node.left, x-1, y-1);
        dfs(node.right, x+1, y-1);
    }
    class Location implements Comparable<Location> {
        int x,y,val;
        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Location that) {
            if (this.x != that.x) {
                return Integer.compare(this.x, that.x);
            } else if (this.y != that.y) {
                return Integer.compare(this.y, that.y);
            } else {
                return Integer.compare(this.val, that.val);
            }
        }

    }
    public static void main(String[] args) {

    }
}
