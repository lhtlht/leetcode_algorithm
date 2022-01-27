package jz;

public class JZ61 {
    public boolean isStraight(int[] nums) {
        int[] p = new int[14];
        int min = 14;
        for (int i:nums) {
            p[i]++;
            if(i<min && i!=0) min=i;
        }
        int j = 0;
        while (j<5) {
            if((min>13 || p[min]<=0) && p[0]<=0){
                return false;
            } else if(min>13 || p[min]<=0) {
                p[0]--;
            }

            j++;
            min++;
        }
        return true;

    }

    public static void main(String[] args) {
        JZ61 j = new JZ61();
        System.out.println(j.isStraight(new int[] {1,2,3,4,5}));
        System.out.println(j.isStraight(new int[] {0,0,1,2,5}));
        System.out.println(j.isStraight(new int[] {0,12,11,11,0}));
        System.out.println(j.isStraight(new int[] {11,10,0,0,12}));
    }
}
