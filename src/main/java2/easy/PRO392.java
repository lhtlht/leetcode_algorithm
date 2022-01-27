package easy;

public class PRO392 {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) return true;
        if (t.equals("")) return false;
        int ls = s.length();
        int lt = t.length();
        int p = 0;
        int q = 0;
        while (p<ls && q<lt) {
            if(s.charAt(p) == t.charAt(q)) {
                p++;
                q++;
            } else {
                q++;
            }
        }
        return p==ls;
    }


    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        PRO392 p = new PRO392();
        System.out.println(p.isSubsequence(s,t));

    }
}
