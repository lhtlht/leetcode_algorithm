package easy;

public class PRO860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i=0; i<bills.length; i++) {
            if (bills[i] == 5) {
                five ++;
            } else if(bills[i] == 10) {
                five --;
                ten ++;
                if (five == 0) return false;
            } else {
                if (ten > 0) {
                    ten --;
                    five --;
                } else {
                    five -= 3;
                }
                if (five == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PRO860 p = new PRO860();
        System.out.println(p.lemonadeChange(new int[] {5,5,5,10,20}));
        System.out.println(p.lemonadeChange(new int[] {5,5,10,10,20}));
    }
}
