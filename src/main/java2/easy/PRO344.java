package easy;

public class PRO344 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i=0; i<n/2; i++){
            char c = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = c;
        }

    }
}
