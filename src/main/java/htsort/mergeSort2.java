package htsort;

public class mergeSort2 {
//    public void sort(int[] nums) {
//        if (nums == null) return;
//        //归并排序
//        int n = nums.length;
//        split(nums,0, n-1);
//    }
//
//    public void split(int[] nums, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//        int mid = start + (end-start)/2;
//        split(nums, start, mid);
//        split(nums, mid+1, end);
//        merge(nums, start, mid, end);
//    }
//
//
//    public void merge(int[] nums, int start, int mid, int end) {
//        int[] copy = new int[nums.length];
//        int p1 = start;
//        int p2= mid+1;
//        int index = start;
//        while (p1 <= mid && p2 <= end){
//            if (nums[p1] < nums[p2]) {
//                copy[index++] = nums[p1++];
//            } else {
//                copy[index++] = nums[p2++];
//            }
//        }
//
//        while (p1 <= mid) copy[index++] = nums[p1++];
//        while (p2 <= end) copy[index++] = nums[p2++];
//        for (int i=start; i<=end; i++) {
//            nums[i] = copy[i];
//        }
//        return;
//    }

//    public int sort(int[] nums, int k) {
//        //快排
//        if (nums == null) return 0;
//        int n = nums.length;
//        quickSort(nums, 0, n-1, k);
//        System.out.println("nums的第k个数：" + k + ":" + nums[k]);
//        return nums[k];
//    }
//
//    public void quickSort(int[] nums, int start, int end, int k) {
//        if (start > end) {
//            return;
//        }
//        int i = start;
//        int j = end;
//        int base = nums[start];
//        while (i < j) {
//            while (i<j && nums[j] >= base) {
//                j--;
//            }
//            nums[i] = nums[j];
//            while (i<j && nums[i] < base) {
//                i++;
//            }
//            nums[j] = nums[i];
//        }
//        nums[i] = base;
//        if (i == k) {
//            return;
//        }
//        quickSort(nums, start, i-1, k);
//        quickSort(nums, i+1, end, k);
//    }

    public void sort(int[] nums) {
        //选择排序
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<n; j++) { //找到最小
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {76,3,54,56,4575,2,85,312};
        mergeSort2 s = new mergeSort2();
        s.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
