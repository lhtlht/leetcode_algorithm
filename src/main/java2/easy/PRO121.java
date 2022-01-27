package easy;

public class PRO121 {
    public int maxProfit(int[] prices) {
        int minp = prices[0];
        int res = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i]-prices[i-1]>0) {
                res = Math.max(res, prices[i]-minp);
            }
            if (prices[i]-prices[i-1]<0) {
                minp = Math.min(minp, prices[i]);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        PRO121 p = new PRO121();
        System.out.println(p.maxProfit(prices));
    }
}
