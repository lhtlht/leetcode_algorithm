package jz;

import java.util.Arrays;

public class JZ40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        quickSort(arr, 0, arr.length-1, k);
        for (int i=0; i<k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int l, int r, int k) {
        if(l >= r) return;
        int i = l;
        int j = r;
        int base = arr[l];
        while (i < j) {
            while (i < j && arr[j] > base) {
                j--;
            }
            arr[i] = arr[j];

            while (i < j && arr[i] <= base) {
                i++;
            }
            arr[j] = arr[i];

        }
        arr[i] = base;
        if(i == k) return;
        quickSort(arr, l,i-1, k);
        quickSort(arr, i+1,r, k);
    }

    public static void main(String[] args) {
        JZ40 j = new JZ40();
        int[] res1 = j.getLeastNumbers(new int[] {3,2,1}, 2); //1,2
        for (int i:res1){
            System.out.println(i);
        }
        int[] res2 =  j.getLeastNumbers(new int[] {0,1,2,1}, 1); //0
        for (int i:res2){
            System.out.println(i);
        }
    }

}
