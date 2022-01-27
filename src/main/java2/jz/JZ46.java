package jz;

public class JZ46 {
    public int translateNum(int num) {
        //0-25
        int a = 1;
        int b = 1;
        int res = 1;
        int pre = num%10;
        num /= 10;
        while (num > 0) {
            int cur = num % 10;
            if(cur == 1 || (cur == 2 && pre <= 5)) {
                res = a + b;


            }
            b = a;
            a = res;
            pre = cur;
            num /= 10;

        }
        return res;
    }

    public static void main(String[] args) {
        JZ46 j = new JZ46();
        System.out.println(j.translateNum(12258)); //5
        System.out.println(j.translateNum(18822)); //4
    }
}
