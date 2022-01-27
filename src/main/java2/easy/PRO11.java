package easy;

public class PRO11 {
    public int maxArea(int[] height) {
        /*
        若向内 移动短板 ，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
        若向内 移动长板 ，水槽的短板 min(h[i], h[j])min(h[i],h[j])​ 不变或变小，因此下个水槽的面积 一定变小

         */
        int i = 0;
        int j = height.length-1;
        int res = (j-i) * Math.min(height[i], height[j]);
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            res = Math.max((j-i) * Math.min(height[i], height[j]), res);
        }

        return res;
    }

    public static void main(String[] args) {
        PRO11 p = new PRO11();
        System.out.println(p.maxArea(new int[] {1,8,6,2,5,4,8,3,7})); //49
        System.out.println(p.maxArea(new int[] {1,1})); //1
        System.out.println(p.maxArea(new int[] {4,3,2,1,4})); //16
    }
}
