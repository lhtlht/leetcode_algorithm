package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution139 {
    /*
    139. 单词拆分
    给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

    说明：

    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        //动态规划
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<s.length()+1; i++) {
            for (String str : wordDict) {
                int len = str.length();
                if (i>=len && dp[i-len] && str.equals(s.substring(i-len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution139 s = new Solution139();
        System.out.println(s.wordBreak("leetcode", new ArrayList<String>(){{
                    add("leet");
                    add("code");
            }}
        ));

        System.out.println(s.wordBreak("applepenapple", new ArrayList<String>(){{
                    add("apple");
                    add("pen");
                }}
        ));



    }

}
