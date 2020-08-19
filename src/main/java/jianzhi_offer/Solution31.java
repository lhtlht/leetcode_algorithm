package jianzhi_offer;

import java.util.LinkedList;
import java.util.Stack;

public class Solution31 {
    /*
    剑指 Offer 31. 栈的压入、弹出序列
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
    例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。



    示例 1：

    输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    输出：true
    解释：我们可以按以下顺序执行：
    push(1), push(2), push(3), push(4), pop() -> 4,
    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
    示例 2：

    输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    输出：false
    解释：1 不能在 2 之前弹出。
     */

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int push = 0;
        int pop = 0;
        int n = pushed.length;
        while (push < n) {
            stack.push(pushed[push]);
            while (!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
            push++;
        }
        if (push == pop) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution31 s = new Solution31();
        System.out.println(s.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1})); //true
        System.out.println(s.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2})); //false
    }
}
