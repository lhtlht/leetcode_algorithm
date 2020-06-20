package easy;

public class Solution14 {
    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。

     示例 1:
     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:
     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/longest-common-prefix
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     时间复杂度O(mn)  字符串数组的平均长度*数组长度
     空间复杂度O（1）
     */

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length==0) {
            return "";
        }
        String prefix = strs[0];
        for (int i=0; i<strs.length; i++) {
            int pos = 0;
            while (pos<prefix.length() && pos<strs[i].length()) {
                if (prefix.charAt(pos)==strs[i].charAt(pos)) {
                    pos ++;
                } else {
                    break;
                }
            }
            if (pos==0) {
                return "";
            }
            prefix = prefix.substring(0,pos);

        }


        return prefix;
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(Solution14.longestCommonPrefix(strs1)); //"fl"
        System.out.println(Solution14.longestCommonPrefix(strs2)); //""

    }
}
