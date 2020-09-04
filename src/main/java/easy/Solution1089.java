package easy;

public class Solution1089 {
    /*
    1089. 复写零
    给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。

    注意：请不要在超过该数组长度的位置写入元素。

    要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
     */
    public void duplicateZeros(int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        int[] copyArr = new int[n];
        for (int i=0; i<n; i++) {
            copyArr[i] = arr[i];
        }

        int i = 0;
        int j = 0;
        boolean skip = true;
        while (i < n) {
            if (copyArr[j] == 0 && skip ) {
                arr[i] = copyArr[j];
                i++;
                skip = false;
            } else {
                arr[i] = copyArr[j];
                i++;
                j++;
            }

        }
    }

    public static void main(String[] args) {
        Solution1089 s = new Solution1089();
        int[] nums = {1,2,3,0,4,5,6};
        s.duplicateZeros(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
