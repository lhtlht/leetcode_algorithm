package easy;

public class PRO557 {
    public String reverseWords(String s) {
        String re = "";
        int n = s.length();
        int start = 0;
        int end = 0;
        while (end < n){
            if (s.charAt(end) == ' '){
                char[] ca = s.substring(start, end).toCharArray();

                re += reverseString2(ca);
                re += " ";
                start = end+1;
            }
            end ++;
        }
        char[] ca = s.substring(start, end).toCharArray();
        re += reverseString2(ca);
        return re;
    }


    public String reverseString2(char[] s) {
        int n = s.length;
        for (int i=0; i<n/2; i++){
            char c = s[i];
            s[i] = s[n-1-i];
            s[n-i-1] = c;
        }
        return new String(s);
    }

    public static void main(String[] args) {
        PRO557 p = new PRO557();
        String s = "Let's take LeetCode contest";
        System.out.println(p.reverseWords("Let's take LeetCode contest"));
    }
}
