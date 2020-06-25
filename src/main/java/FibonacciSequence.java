public class FibonacciSequence {
    //	Fibonacci sequence 斐波那契数列

    //暴力递归
    public int fib(int n) {
        if (n<1) return 0;
        if (n==1 || n==2) {
            return 1;
        }

        return fib(n-2)+fib(n-1);
    }

    //备忘录存储
    public int fib2(int n) {
        if (n<1) return 0;
        if (n==1 || n==2) {
            return 1;
        }
        int[] note = new int[n+1];
        note[1] = 1;
        note[2] = 1;
        mem(note, n);
        return note[n];
    }
    public int mem(int[] note, int n) {
        if (n==1 || n==2) {
            return 1;
        }
        if (note[n]>0) {
            return note[n];
        }
        note[n] = mem(note, n-2) + mem(note, n-1);
        return note[n];
    }


    //动态规划
    public int fib3(int n) {
        if (n<1) return 0;
        if (n==1 || n==2) {
            return 1;
        }
        int[] note = new int[n+1];
        note[1] = 1;
        note[2] = 1;
        for (int i=3; i<note.length;i++) {
            note[i] = note[i-2]+note[i-1];
        }
        return note[n];

    }

    //动态规划优化
    public int fib4(int n) {
        if (n<1) return 0;
        if (n==1 || n==2) {
            return 1;
        }
        int[] note = new int[4];
        note[1] = 1;
        note[2] = 1;
        for (int i=3; i<n+1;i++) {
            note[3] = note[2]+note[1];
            note[1] = note[2];
            note[2] = note[3];
        }
        return note[3];

    }

    public static void main(String[] args) {
        FibonacciSequence fs = new FibonacciSequence();
        System.out.println(fs.fib(10));
        System.out.println(fs.fib2(10));
        System.out.println(fs.fib3(10));
        System.out.println(fs.fib4(10));


    }
}
