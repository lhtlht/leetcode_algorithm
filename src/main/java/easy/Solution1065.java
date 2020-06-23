package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1065 {
    public static int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<int[]>();
        for (String w:words) {
            int i = 0;
            while (i<=(text.length()-w.length())) {
                int strStart = text.indexOf(w,i);
                if (strStart==-1) break;
                i = strStart + 1;
                int[] tmp = {strStart, strStart + w.length() - 1};
                list.add(tmp);
            }

        }

        //Collections.sort(list,(int[] a, int[] b) -> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);//排序
        return list.toArray(new int[list.size()][2]);//list转化为int[][]

    }

    public static void main(String[] args) {
        String text = "thestoryofleetcodeandmestory";
        String[] words = {"story","fleet","leetcode"};
        //System.out.println(text.indexOf("storyy",0));
        int[][] res = Solution1065.indexPairs(text, words);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
        System.out.println("----------------------------------");
        String text1 = "ababa";
        String[] words1 = {"aba","ab"};
        //System.out.println(text.indexOf("storyy",0));
        int[][] res1 = Solution1065.indexPairs(text1, words1);
        for (int i=0; i<res1.length; i++) {
            System.out.println(res1[i][0] + " " + res1[i][1]);
        }

    }
}
