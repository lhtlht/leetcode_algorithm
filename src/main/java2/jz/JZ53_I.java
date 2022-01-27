package jz;

public class JZ53_I {
    public int search(int[] nums, int target) {
        int res = 0;

        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            if(nums[mid] == target) {
                res ++;
                break;
            } else if (nums[mid] > target) {
                right = mid-1;

            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(mid);
        int i = mid-1;
        int j = mid+1;
        while (i>=left && i>=0) {
            if(nums[i] == target) {
                res++;
                i--;
            } else {
                break;
            }
        }

        while (j<=right ) {
            if(nums[j] == target) {
                res++;
                j++;
            } else {
                break;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        JZ53_I j = new JZ53_I();
        //System.out.println(j.search(new int[] {5,7,7,8,8,10}, 8));
        System.out.println(j.search(new int[] {1,1,2}, 1));
    }
}
