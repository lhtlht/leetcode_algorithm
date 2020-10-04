package jianzhi_offer;

public class Solution53_I {
    /*
    剑指 Offer 53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。
     */
    public int search(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length < 1) return count;
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        while (l < r){
            mid = l + (r-l)/2;
            //System.out.println("mid:" + mid);
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        int p = mid;
        int q = mid+1;
        while (p >= 0 && nums[p] == target) {
            count++;
            p--;
        }
        while (q < nums.length && nums[q] == target) {
            count++;
            q++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution53_I s = new Solution53_I();
        System.out.println(s.search(new int[] {5,7,7,8,8,10}, 7)); //2
        System.out.println(s.search(new int[] {1,4}, 4)); //1
        System.out.println(s.search(new int[] {1,2,3}, 3)); //1
    }
}
