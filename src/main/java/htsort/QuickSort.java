package htsort;

public class QuickSort {
    /*
    时间复杂度： nlog2n
    空间复杂度： nlog2n
     */
    public void quickSort(int[] nums, boolean ascending) {
        //ascending false : 降序
        quickSortHelp(nums, 0, nums.length-1, ascending);
    }

    public void quickSortHelp(int[] nums, int left, int right, boolean ascending) {
        if (left >= right) {
            return;
        }
        int base = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            if (ascending) {
                //正序
                while (l < r && nums[r] >= base) {
                    r--;
                }
                nums[l] = nums[r];
                while (l < r && nums[l] < base) {
                    l++;
                }
            } else {
                //降序
                while (l < r && nums[r] <= base) {
                    r--;
                }
                nums[l] = nums[r];
                while (l < r && nums[l] > base) {
                    l++;
                }
            }

            nums[r] = nums[l];
        }
        nums[l] = base;
        quickSortHelp(nums, left, l-1, ascending);
        quickSortHelp(nums, l+1, right, ascending);
    }


    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] nums = {2,1, 4, 6, 8, 2};
        s.quickSort(nums,false);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
