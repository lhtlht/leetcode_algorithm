package easy;

import java.util.Arrays;
import java.util.Comparator;

public class PRO406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        int[][] res = new int[people.length][2];
        for (int i=0; i<people.length; i++) {
            if (people[i][1] >= i) {
                res[i] = people[i];
            } else {
                int target = people[i][1];
                for (int j=i; j>target; j--) {
                    res[j] = res[j-1];
                }
                res[target] = people[i];
            }
        }



        return res;
    }

    public static void main(String[] args) {
        PRO406 p = new PRO406();
        int[][] people = {
                {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };
        int[][] res = p.reconstructQueue(people);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i][0] + ":" + res[i][1]);
        }

    }
}
