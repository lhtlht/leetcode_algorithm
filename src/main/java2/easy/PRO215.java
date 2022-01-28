package easy;

public class PRO215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1, k);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("----------");
        return nums[k-1];
    }

    public void quickSort(int[] nums, int l, int r, int k) {
        if (l > r){
            return;
        }
        int left = l;
        int right = r;
        int base = nums[l];
        while (left < right) {
            while (left < right && nums[right] < base){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= base) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        if (left == k-1) return;
        if (left > k-1) {
            quickSort(nums, l, left-1, k);
        } else {
            quickSort(nums, left+1, r, k);
        }



    }

    public static void main(String[] args) {
        PRO215 p = new PRO215();
        System.out.println(p.findKthLargest(new int[] {3,2,1,5,6,4}, 2)); //5
        //System.out.println(p.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4)); //4
    }
}
