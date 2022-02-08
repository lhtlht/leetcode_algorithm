package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PRO139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wd = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] && wd.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        PRO139 p = new PRO139();
        List<String> wd = new ArrayList<String>();
        wd.add("leet");
        wd.add("code");
        System.out.println(p.wordBreak("leetcode",wd));
    }
}
