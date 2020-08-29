package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1104 {
    /*
    1104. 二叉树寻路
    在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

    如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

    而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。



    给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
     */

    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<Integer>();

        int label2 = label;
        int n = 1;
        while (label2 > 1) {
            n++;
            label2 /= 2;
        }


        res.push(label);
        n--;
        while (label > 1) {
            int max = (int)(Math.pow(2,n)-1);
            int min = (int)(Math.pow(2,n-1));
            label /= 2;
            label = (max-label) < (label-min) ? min+(max-label) : max-(label-min);
            res.push(label);
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1104 s = new Solution1104();
        System.out.println(s.pathInZigZagTree(26));
    }
}
