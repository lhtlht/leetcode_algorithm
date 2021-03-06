package easy;

import java.util.HashSet;
import java.util.Set;

public class Solution771 {
    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     示例 1:
     输入: J = "aA", S = "aAAbbbb"
     输出: 3

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/jewels-and-stones
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param J
     * @param S
     * @return
     */
    public static int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> setJ = new HashSet<Character>();
        for (char j: J.toCharArray()) {
            setJ.add(j);
        }
        for (char s:S.toCharArray()) {
            if (setJ.contains(s)) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(Solution771.numJewelsInStones(J,S)); //3
    }
}
