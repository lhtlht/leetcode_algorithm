package easy;

public class PRO287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p1 = 0;
        int p2 = slow;
        while (p1!=p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public static void main(String[] args) {
        PRO287 p = new PRO287();
        System.out.println(p.findDuplicate(new int[] {1,3,4,2,2})); //2
        System.out.println(p.findDuplicate(new int[] {3,1,3,4,2})); //3
    }
}
