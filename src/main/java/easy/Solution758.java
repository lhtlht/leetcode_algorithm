package easy;

public class Solution758 {
    /**
     * 758. 字符串中的加粗单词
     * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 <b> 和 </b> 中的字母都会加粗。
     * 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
     * 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。
     *
     * 注：
     * words 长度的范围为 [0, 50]。
     * words[i] 长度的范围为 [1, 10]。
     * S 长度的范围为 [0, 500]。
     * 所有 words[i] 和 S 中的字符都为小写字母。
     * @param words
     * @param S
     * @return
     */
    public static String boldWords(String[] words, String S) {
        boolean[] isBold = new boolean[S.length()];
        for (String word : words) { //把所有出现关键词的位置全部标记为true
            int n = S.indexOf(word, 0);
            while (n != -1) {
                for (int i = n; i < n + word.length(); i++) isBold[i] = true;
                n = S.indexOf(word, n + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isBold[0]) {
            sb.append("<b>");
        }

        for (int i=0; i<isBold.length; i++) {
            sb.append(S.charAt(i));
            if (i==isBold.length-1) {
                if (isBold[i]) sb.append("</b>");
                break;
            }
            if (isBold[i] && !isBold[i+1]) sb.append("</b>");
            if (!isBold[i] && isBold[i+1]) sb.append("<b>");
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"ab", "bc"};
        String S = "aabcd";
        System.out.println(Solution758.boldWords(words, S));
    }
}
