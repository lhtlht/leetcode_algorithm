package easy;

public class SolutionLCP02 {
    /**
     * LCP 02. 分式化简
     * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
     *
     *
     *
     * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
     *
     *
     *
     * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
     */


    public static int[] fraction(int[] cont) {
        int mu = cont[cont.length-1];
        int zi = 1;
        for (int i=cont.length-2; i>=0; i--) {
            int tmp = mu;
            mu = mu*cont[i]+zi;
            zi = tmp;
            //System.out.println(zi + "/" + mu);
        }
        return new int[]{mu, zi};
    }


    public static void main(String[] args) {
        int[] cont = {3, 2, 0, 2};
        int[] res = SolutionLCP02.fraction(cont); //[13, 4]
        for (int i:res) {
            System.out.print(i+" ");
        }

    }
}
