package jz;

public class JZ58_1 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] sArray = s.split(" ");
        StringBuffer res = new StringBuffer();
        int i = 0;
        int len = sArray.length - 1;
        while (len >= 0) {
            if(!sArray[len].equals("")) {
                res.append(sArray[len]);
                res.append(" ");
                len --;
            } else {
                while (len >= 0 && sArray[len].equals("")) {
                    len --;
                }
            }
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        JZ58_1 j = new JZ58_1();
        System.out.println(j.reverseWords("the sky is blue"));
        System.out.println(j.reverseWords("  hello world!  "));
    }
}
