package jz;

public class JZ63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++) {
            res = Math.max(prices[i]-min, res);
            min = Math.min(prices[i], min);
        }
        return res;
    }

    public static void main(String[] args) {
        JZ63 j = new JZ63();
        System.out.println(j.maxProfit(new int[] {7,1,5,3,6,4})); //5
        System.out.println(j.maxProfit(new int[] {7,6,4,3,1})); //0
    }

}
