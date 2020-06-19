package easy;

public class Solution1119 {
    public static String removeVowels(String S) {
        String res = "";
        String vowels = "aeiou";
        for (int i=0; i<S.length(); i++) {
            if (vowels.indexOf(S.charAt(i))==-1) {
                res += S.charAt(i);
            }
        }
        return res;
    }

    public static String removeVowels2(String S) {
        return S.replaceAll("[aeiou]","");

    }

    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(Solution1119.removeVowels(s));
        System.out.println(Solution1119.removeVowels2(s));

    }
}
