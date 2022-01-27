package easy;

import ht_tree.TreeNode;

public class pro100 {
    /*
    时间复杂度 O（min(m,n)) 取决两颗树的最小深度，遍历深搜
    空间复杂度 O（min(m,n)) 取决两颗树的最小层
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.value != q.value) {
            return false;
        }
        if (!isSameTree(p.left,q.left)) {
            return false;
        }
        if (!isSameTree(p.right,q.right)){
            return false;
        }
        return true;


    }
}
