package easy;

public class Solution1122 {
    /*
    1122. 数组的相对排序
    给你两个数组，arr1 和 arr2，

    arr2 中的元素各不相同
    arr2 中的每个元素都出现在 arr1 中
    对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。



    示例：

    输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    输出：[2,2,2,1,4,3,3,9,6,7,19]
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num1 : arr1) {
            count[num1]++;
        }
        int i=0;
        for (int num2 : arr2) {
            while (count[num2]>0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }

        for (int num1 = 0; num1<count.length; num1++) {
            while (count[num1]>0) {
                arr1[i++] = num1;
                count[num1]--;
            }
        }
        return arr1;

    }

    public static void main(String[] args) {
        Solution1122 s = new Solution1122();
        int[] res = s.relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[] {2,1,4,3,9,6});
        for (int num:res) {
            System.out.print(num + " ");
        }
    }
}
