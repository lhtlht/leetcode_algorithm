package easy;

public class Solution836 {
    /**
     * 836. 矩形重叠
     * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
     *
     * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
     *
     * 给出两个矩形，判断它们是否重叠并返回结果。
     * @param rec1
     * @param rec2
     * @return
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean x_overlap = !(rec1[2]<=rec2[0] || rec2[2]<=rec1[0]);
        boolean y_overlap = !(rec1[3]<=rec2[1] || rec2[3]<=rec1[1]);

        return x_overlap && y_overlap;
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,2,2}, rec2 = {1,1,3,3};
        int[] rec11 = {0,0,1,1}, rec22 = {1,0,2,1};

        System.out.println(Solution836.isRectangleOverlap(rec1,rec2)); //true
        System.out.println(Solution836.isRectangleOverlap(rec11,rec22)); //false

    }
}
