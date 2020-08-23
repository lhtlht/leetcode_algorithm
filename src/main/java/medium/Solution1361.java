package medium;

public class Solution1361 {
    /*
    1361. 验证二叉树
    二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。

    只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。

    如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。

    注意：节点没有值，本问题中仅仅使用节点编号。
     */

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        return false;
    }

    public static void main(String[] args) {
        Solution1361 s = new Solution1361();
        System.out.println(s.validateBinaryTreeNodes(4, new int[] {1,-1,3,-1}, new int[] {2,-1,-1,-1})); //true
        System.out.println(s.validateBinaryTreeNodes(4, new int[] {1,-1,3,-1}, new int[] {2,3,-1,-1})); //false

    }
}
