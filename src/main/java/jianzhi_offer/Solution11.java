package jianzhi_offer;

public class Solution11 {
    /*
    剑指 Offer 11. 旋转数组的最小数字
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

    示例 1：

    输入：[3,4,5,1,2]
    输出：1
    示例 2：

    输入：[2,2,2,0,1]
    输出：0
     */
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        int index = 0;

        while (left < right) {
            if (numbers[right] > numbers[left]) return numbers[left];
            int mid = left + (right-left)/2;

            if (numbers[mid] > numbers[mid+1]) {
                return numbers[mid+1];
            }
            if (mid-1 > 0 && numbers[mid] < numbers[mid-1]) {
                return numbers[mid];
            }

            if (numbers[mid] > numbers[left]) {
                left = mid+1;
            } else if (numbers[mid] < numbers[left]){
                right = mid;
            } else {
                left++;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        Solution11 s = new Solution11();
        System.out.println(s.minArray(new int[] {3,4,5,1,2})); //1
        System.out.println(s.minArray(new int[] {2,2,2,0,1})); //0
        System.out.println(s.minArray(new int[] {2,2,0,0,1})); //0
        System.out.println(s.minArray(new int[] {2,2,3,5,1})); //1
        System.out.println(s.minArray(new int[] {1,3,5})); //1
        System.out.println(s.minArray(new int[] {1,1})); //1
        System.out.println(s.minArray(new int[] {3,3,3,1})); //1
        System.out.println(s.minArray(new int[] {10,1,10,10,10}));
    }
}
