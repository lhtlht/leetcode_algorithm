package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution49 {
    /*
    49. 字母异位词分组
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    示例:

    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    说明：

    所有输入均为小写字母。
    不考虑答案输出的顺序。
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] prims = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        HashMap<Integer,  List<String>> hash = new HashMap<Integer,  List<String>>();
        for (String str : strs) {
            int hashValue = 1;
            for (int i = 0; i<str.length(); i++) {
                hashValue *= prims[str.charAt(i)-'a'];
            }

            if (hash.containsKey(hashValue)) {
                List<String> curList = hash.get(hashValue);
                curList.add(str);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                hash.put(hashValue, newList);

            }
        }

        return new ArrayList<List<String>>(hash.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution49 s = new Solution49();
        System.out.println(s.groupAnagrams(strs));
    }
}
