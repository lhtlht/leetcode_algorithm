package easy;

public class PRO26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int res = 0;

        for (int i=1; i<n; i++) {
            if (nums[i] != nums[res]) {
                res++;
                nums[res] = nums[i];
            }
        }
        return res+1;
    }

    public static void main(String[] args) {
        PRO26 p = new PRO26();
        System.out.println(p.removeDuplicates(new int[] {1,1,2})); //2
        System.out.println(p.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4})); //5
    }
}
