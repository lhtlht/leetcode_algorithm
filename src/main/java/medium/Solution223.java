package medium;

public class Solution223 {
    /*
    223. 矩形面积
    在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

    每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
     */

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        //无交叉情况
        if (E >= C || G <= A || F >= D || H <= B) {
            return area1+area2;
        }
        //交叉

        int bottemX = Math.max(A,E);
        int bottemY = Math.max(B,F);
        int topX = Math.min(C,G);
        int topY = Math.min(D,H);

        return area1 - (topX-bottemX)*(topY-bottemY) + area2;
    }


    public static void main(String[] args) {
        Solution223 s = new Solution223();
        System.out.println(s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2)); //45
    }
}
