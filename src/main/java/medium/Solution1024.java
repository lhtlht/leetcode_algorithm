package medium;

import java.util.*;

public class Solution1024 {
    /*
    1024. 视频拼接
    你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。

    视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

    我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
     */
    public int videoStitching(int[][] clips, int T) {
        //上一个片段的结束值
        int sMin = 0;
        int sMax = 0;
        int count = 0;
        for (int i=0; i<=T; i++) {
            sMax = 0;
            for (int j=0; j<clips.length; j++) {
                if (clips[j][0] <= sMin) {
                    sMax = Math.max(sMax, clips[j][1]);
                }
            }
            count++;
            if (sMax >= T) {
                return count;
            }
            sMin = sMax;
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution1024 s = new Solution1024();
        //System.out.println(s.videoStitching(new int[][] {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10)); //3
        //System.out.println(s.videoStitching(new int[][] {{0,1},{1,2}}, 5)); //-1
        System.out.println(s.videoStitching(new int[][] {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}},9));
    }
}
