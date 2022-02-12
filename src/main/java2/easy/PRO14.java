package easy;

public class PRO14 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1){
            return strs[0];
        }
        String base = strs[0];
        int len = base.length();
        for (int i=0; i<len; i++) {
            char c = base.charAt(i);
            for (int j=1; j<n; j++){
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return base.substring(0,i);
                }
            }
        }
        return base;


    }

    public static void main(String[] args) {

    }
}
