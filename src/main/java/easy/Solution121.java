package easy;

public class Solution121 {
    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i=0; i<prices.length-1; i++) {
            for (int j=i+1; j<prices.length; j++) {
                res = Math.max(prices[j]-prices[i], res);
            }
        }
        return res;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length<1){
            return 0;
        }
        int res = 0;
        int buy = prices[0];
        for (int i=1; i<prices.length; i++) {
            res = Math.max(prices[i]-buy, res);
            buy = Math.min(prices[i], buy);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        int[] prices3 = {};
        System.out.println(Solution121.maxProfit2(prices1)); //5
        System.out.println(Solution121.maxProfit2(prices2)); //0
        System.out.println(Solution121.maxProfit2(prices3)); //0

    }
}
