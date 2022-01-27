package jz;

public class JZ65 {
    public int add(int a, int b) {
        //& 运算 + 异或运算 = 和s
        while (b != 0) {
            int c = (a&b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
