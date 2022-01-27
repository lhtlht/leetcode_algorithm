public class NumsSort {
    /*冒泡排序*/
    /*
    * 时间复杂度：
    * 空间复杂度：
    * */
    public int[] bubbleSort(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j]<nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return nums;
    }
    /*快速排序*/
    public void quickSort(int[] nums) {
        quickSortHelp(0, nums.length-1, nums);
    }
    public void quickSortHelp(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }
        int base = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] >= base) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] < base) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = base;
        quickSortHelp(left,l-1,nums);
        quickSortHelp(l+1,right,nums);
    }


    /*桶排序*/


    /*插入排序*/
    public void insertSort(int[] nums) {
        for (int j=1; j<nums.length; j++) {
            int tmp = nums[j];
            int i = j-1;
            while (i>=0 && tmp<nums[i]) {
                nums[i+1] = nums[i];
                i--;
            }
            nums[i+1] = tmp;
        }
    }

    /*归并排序*/
    /*
    *递归深度：log2n
    */
    public void mergeSort(int[] nums) {
        int[] res = new int[nums.length];
        mergeSortHelp(0, nums.length-1, nums, res);
    }
    public void mergeSortHelp(int left, int right, int[] nums, int[] res) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)/2;
        mergeSortHelp(left,mid, nums, res);
        mergeSortHelp(mid+1,right, nums, res);
        int l = left;
        int r = mid+1;
        int i = left;
        while (l<= mid && r<=right) {
            if (nums[l]<=nums[r]) {
                res[i] = nums[l];
                l++;
            } else {
                res[i] = nums[r];
                r++;
            }
            i++;
        }
        while (l <= mid) {
            res[i++] = nums[l++];
        }
        while (r <= right) {
            res[i++] = nums[r++];
        }


        for (i=left; i<=right; i++) {
            nums[i] = res[i];
        }



    }


    /*希尔排序*/

    /*选择排序*/

    public static void main(String[] args) {
        int[] nums = {1,3,2,7,9,10,23,22,11,12};
        NumsSort p = new NumsSort();
        p.mergeSort(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
