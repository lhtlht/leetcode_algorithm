package jz;

public class JZ33 {
    public boolean verifyPostorder(int[] postorder) {
        return reTree(postorder, 0, postorder.length-1);
    }

    public boolean reTree(int[] postorder, int i, int j) {
        if (i >= j) return true;
        // j 为根节点
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && reTree(postorder, i, m-1) && reTree(postorder, m, j-1);
    }

    public static void main(String[] args) {
        JZ33 j = new JZ33();
        System.out.println(j.verifyPostorder(new int[] {1,6,3,2,5})); //false
        System.out.println(j.verifyPostorder(new int[] {1,3,2,6,5})); //true
    }
}
