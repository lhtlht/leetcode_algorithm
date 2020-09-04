package easy;

import java.util.Arrays;

public class Solution475 {
    /*
    475. 供暖器
    冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。

    现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。

    所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。

    说明:

    给出的房屋和供暖器的数目是非负数且不会超过 25000。
    给出的房屋和供暖器的位置均是非负数且不会超过10^9。
    只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
    所有供暖器都遵循你的半径标准，加热的半径也一样。
    示例 1:

    输入: [1,2,3],[2]
    输出: 1
    解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (int house : houses) {
            int index = binarySearch(heaters, house);
            if (index < 0) {
                index = -(index+1);
                int leftDist = index - 1 >= 0? house-heaters[index-1] : Integer.MAX_VALUE;
                int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                ans = Math.max(ans, Math.min(leftDist, rightDist));
            }
        }
        return ans;
    }

    public int binarySearch(int[] heaters, int house) {
        int low = 0;
        int high = heaters.length-1;
        while (low <= high) {
            int mid = low + (high - low) /2;
            if (heaters[mid] == house) {
                return mid;
            } else if (heaters[mid] < house) {
                low  = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -(low+1);


    }


    public static void main(String[] args) {
        Solution475 s = new Solution475();
        System.out.println(s.findRadius(new int[] {1,2,3}, new int[] {2}));
    }
}
