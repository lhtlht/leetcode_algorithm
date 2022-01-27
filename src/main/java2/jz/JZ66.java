package jz;

public class JZ66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        int tmp = 1;
        for (int i=0; i<n; i++) {
            res[i] = tmp;
            tmp *= a[i];
        }
        tmp = 1;
        for (int i=n-1; i>=0; i--) {
            res[i] *= tmp;
            tmp *= a[i];
        }

        return res;
    }


    public static void main(String[] args) {
        JZ66 j = new JZ66();
        int[] res = j.constructArr(new int[] {1,2,3,4,5}); //[120,60,40,30,24]
        for (int num : res) {
            System.out.println(num);
        }
    }
}
