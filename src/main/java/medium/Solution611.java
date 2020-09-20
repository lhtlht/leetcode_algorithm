package medium;

import java.util.Arrays;

public class Solution611 {
    /*
    611. 有效三角形的个数
    给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

    示例 1:

    输入: [2,2,3,4]
    输出: 3
    解释:
    有效的组合是:
    2,3,4 (使用第一个 2)
    2,3,4 (使用第二个 2)
    2,2,3
    注意:

    数组长度不超过1000。
    数组里整数的范围为 [0, 1000]。
     */

    public int triangleNumber(int[] nums) {
        int count = 0;
        int n = nums.length;
        if (n < 3) return count;
        int[] triangle = new int[3];
        for (int i=0; i<n-2; i++) {
            triangle[0] = nums[i];
            for (int j=i+1; j<n-1; j++) {
                triangle[1] = nums[j];
                for (int k=j+1; k<n; k++) {
                    triangle[2] = nums[k];
                    if (isTriangle(triangle)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public int triangleNumber2(int[] nums) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<n-2; i++) {
            int k = i+2;
            for (int j=i+1; j<n-1 && nums[i]!=0; j++) {
                while (k < n && nums[i]+nums[j]>nums[k]) {
                    k++;
                }
                count += k-j-1;

            }
        }
        return count;
    }


    public boolean isTriangle(int[] triangle) {
        return triangle[0]+triangle[1]>triangle[2] && triangle[0]+triangle[2]>triangle[1] && triangle[1]+triangle[2]>triangle[0];
    }


    public static void main(String[] args) {
        Solution611 s = new Solution611();
        System.out.println(s.triangleNumber2(new int[] {2,2,3,4})); //3
        System.out.println(s.triangleNumber2(new int[] {1,1,3,4})); //0
        System.out.println(s.triangleNumber2(new int[] {1,2,3,4,5,6})); //7
    }
}
