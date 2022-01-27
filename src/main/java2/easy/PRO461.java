package easy;

public class PRO461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z > 0) {
            res += z%2;
            z /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        PRO461 p = new PRO461();
        System.out.println(p.hammingDistance(1,4));
        System.out.println(p.hammingDistance(3,1));
    }
}
