package htsort;

public class MergeSort {

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        split(nums, 0, nums.length-1);
    }

    public void split(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end-start)/2;
            split(nums, start, mid);
            split(nums, mid+1, end);
            mergeTwo(nums, start, mid, end);
        }
    }

    public void mergeTwo(int[] nums, int start, int mid, int end) {
        int[] copy = new int[nums.length];
        int p1 = start;
        int p2 = mid+1;
        int i = start;
        while (p1 <= mid && p2 <= end) {
            if (nums[p1] < nums[p2]) {
                copy[i] = nums[p1];
                p1++;
            } else {
                copy[i] = nums[p2];
                p2++;
            }
            i++;
        }
        while (p1 <= mid) copy[i++] = nums[p1++];
        while (p2 <= end) copy[i++] = nums[p2++];
        for (int j=start; j<=end; j++) {
            nums[j] = copy[j];
        }
    }


    public static void main(String[] args) {
        int[] nums = {38, 27, 43, 3, 9, 82, 10};
        MergeSort ms = new MergeSort();
        ms.mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
