package easy;

import java.util.LinkedList;
import java.util.Stack;

public class PRO739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (temperatures[j]>temperatures[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> index = new Stack<Integer>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            while (!index.isEmpty() && temperatures[i] > temperatures[index.peek()]) {
                int j = index.pop();
                res[j] = i-j;
            }
            index.add(i);

        }
        return res;
    }

    public static void main(String[] args) {
        PRO739 p = new PRO739();
        int[] res = p.dailyTemperatures2(new int[] {73,74,75,71,69,72,76,73}); //[1,1,4,2,1,1,0,0]
        for (int num : res) {
            System.out.println(num);
        }
    }
}
