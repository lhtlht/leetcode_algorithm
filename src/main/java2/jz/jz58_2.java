package jz;

public class jz58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuffer rs = new StringBuffer();
        for (int i=n-1; i<s.length(); i++) {
            rs.append(s.charAt(i));
        }
        for (int i=0; i<n; i++) {
            rs.append(s.charAt(i));
        }
        return rs.toString();
    }
}
