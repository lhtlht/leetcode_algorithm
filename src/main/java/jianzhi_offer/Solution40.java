package jianzhi_offer;

import java.util.Arrays;

public class Solution40 {
    /*
    最小k个数
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, k);
        return Arrays.copyOfRange(arr,0,k);

    }
    //非递归
    public void quickSort(int[] arr, int k) {
        int start  = 0;
        int end = arr.length - 1;
        while (start < end) {
            int base = arr[start];
            int i = start;
            int j = end;
            while (i <= j) {
                while (i <= j && arr[j] > base) {
                    j--;
                }
                while (i <= j && arr[i] < base) {
                    i++;
                }
                if (i <= j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }
            }
            if (i >= k) {
                end = i - 1;
            } else {
                start = i;
            }


        }
    }

    public static void main(String[] args) {
        Solution40 s = new Solution40();
        s.getLeastNumbers(new int[] {3,2,1},2);
    }
}
