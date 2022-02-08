package medium;


import java.util.ArrayList;

public class Solution792 {
    /*
    792. 匹配子序列的单词数
    给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。

    示例:
    输入:
    S = "abcde"
    words = ["a", "bb", "acd", "ace"]
    输出: 3
    解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
    注意:

    所有在words和 S 里的单词都只由小写字母组成。
    S 的长度在 [1, 50000]。
    words 的长度在 [1, 5000]。
    words[i]的长度在[1, 50]。
     */
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String s : words) {
            if (isSub(S,s)) count++;
        }
        return count;
    }

    public boolean isSub(String S, String s) {
        int i = 0;
        int j = 0;
        while (i < S.length() && j < s.length()) {
            if (S.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (j == s.length()) {
            return true;
        } else {
            return false;
        }
    }


    public int numMatchingSubseq2(String S, String[] words) {
        //分桶
        int count = 0;
        ArrayList<Node>[] maps = new ArrayList[26];
        for (int i=0; i<26; i++) {
            maps[i] = new ArrayList<Node>();
        }

        for (String word : words) {
            maps[word.charAt(0) - 'a'].add(new Node(word, 0));
        }


        for (char c : S.toCharArray()) {
            ArrayList<Node> curr = maps[c-'a'];
            maps[c-'a'] = new ArrayList<Node>();
            for (Node node : curr) {
                node.index++;
                if (node.index == node.word.length()) {
                    count++;
                } else {
                    maps[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            curr.clear();
        }
        return count;
    }

    class Node {
        String word;
        int index;
        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }

    public static void main(String[] args) {
        Solution792 s = new Solution792();
        System.out.println(s.numMatchingSubseq("abcde", new String[] {"a", "bb", "acd", "ace"})); //3
    }
}
