package easy;

public class PRO231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;
        while (n != 1 && n != -1) {
            if (n%2 != 0){
                return false;
            }
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        PRO231 p = new PRO231();
        System.out.println(p.isPowerOfTwo(1)); //true
        System.out.println(p.isPowerOfTwo(16)); //true
        System.out.println(p.isPowerOfTwo(3)); //false
        System.out.println(p.isPowerOfTwo(4)); //true
        System.out.println(p.isPowerOfTwo(-16)); //false
    }
}
