package easy;

public class PRO169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count ++;
            } else if(num == res) {
                count ++;
            } else {
                count --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PRO169 p = new PRO169();
        System.out.println(p.majorityElement(new int[] {6,5,5}));
    }
}
