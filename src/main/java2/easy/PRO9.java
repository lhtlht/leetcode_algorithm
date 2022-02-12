package easy;

public class PRO9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x != 0)) return false;
        int reNum = 0;
        while (x > reNum) {
            reNum = reNum*10 + x%10;
            x /= 10;
        }
        return x == reNum || x == reNum/10;
    }

    public static void main(String[] args) {
        PRO9 p = new PRO9();
        System.out.println(p.isPalindrome(121)); //true
        System.out.println(p.isPalindrome(-121)); //false
        System.out.println(p.isPalindrome(10)); //false
        System.out.println(p.isPalindrome(-101)); //false
    }
}
