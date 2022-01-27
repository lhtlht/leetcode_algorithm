package jz;

public class JZ50 {
    public char firstUniqChar(String s) {
        int[] d = new int[26];
        for(int i=0; i<s.length(); i++) {
            d[s.charAt(i)-97] ++;
        }
        for(int i=0; i<s.length(); i++) {
            if(d[s.charAt(i)-97]==1) return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println('a'+0);
        System.out.println('z'+0);
    }
}
