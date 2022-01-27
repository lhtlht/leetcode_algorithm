package jz;

public class JZ05 {
    public String replaceSpace(String s) {
        StringBuffer rs = new StringBuffer();
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                rs.append("%20");
            } else {
                rs.append(s.charAt(i));
            }
        }
        return rs.toString();
    }
}
