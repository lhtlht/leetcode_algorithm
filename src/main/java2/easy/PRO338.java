package easy;

public class PRO338 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i=1; i<n+1; i++) {
            res[i] = res[i/2]+i%2;
        }
        return res;
    }

    public static void main(String[] args) {
        PRO338 p = new PRO338();
        int[] res = p.countBits(5);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
