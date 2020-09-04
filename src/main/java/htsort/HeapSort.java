package htsort;

public class HeapSort {
    /*
    堆排序
     */

    public void sink(int[] nums, int parent, int len) {
        //下沉
        int p = nums[parent];
        int l = parent*2+1;
        while (l < len) {
            //取两个孩子最大的一个
            if (l+1 < len && nums[l+1] > nums[l]) {
                l++;
            }
            if (p > nums[l]) {
                break;
            }

            nums[parent] = nums[l];
            parent = l;
            l = 2*l+1;
        }
        nums[parent] = p;
    }
    public void heapSort(int[] nums, boolean ascending) {
        int n = nums.length;
        //忽略大小为1的子堆，即叶子节点
        //从叶子节点的父节点开始遍历，利用下沉操作，sink
        //堆顶为最大值
        for (int i=(n-1)/2; i>=0; i--) {
            sink(nums, i, n);
        }

        for (int i=nums.length-1; i>=0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;

            sink(nums, 0, i);
        }

    }
    public static void main(String[] args) {
        HeapSort s = new HeapSort();
        int[] nums = {2,1, 4, 6, 8, 2};
        s.heapSort(nums,false);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
