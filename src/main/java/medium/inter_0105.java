package medium;

public class inter_0105 {
    /*
    面试题 01.05. 一次编辑
    字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。



    示例 1:

    输入:
    first = "pale"
    second = "ple"
    输出: True


    示例 2:

    输入:
    first = "pales"
    second = "pal"
    输出: False
     */
    public boolean oneEditAway(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        if (Math.abs(l1-l2) > 1) {
            return false;
        }
        int s = 0;
        if (l1 == l2) {
            //改操作
            int index = 0;
            while (index < l1) {
                if (first.charAt(index) != second.charAt(index)) {
                    s++;
                    if (s > 1) {
                        return false;
                    }
                }
                index++;
            }
        } else {
            //增删操作
            int i = 0;
            int j = 0;
            if (l1 > l2) {
                while (i < l1 && j < l2) {
                    if (first.charAt(i) != second.charAt(j)) {
                        if (s > 1) {
                            return false;
                        }
                        s++;
                        i++;
                    } else {
                        i++;
                        j++;
                    }
                }
            } else {
                while (j < l2 && i < l1) {
                    if (first.charAt(i) != second.charAt(j)) {
                        if (s > 1) {
                            return false;
                        }
                        s++;
                        j++;
                    } else {
                        i++;
                        j++;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        inter_0105 s = new inter_0105();
        //System.out.println(s.oneEditAway("pale", "ple"));
        //System.out.println(s.oneEditAway("pales", "pal"));
        System.out.println(s.oneEditAway("","a")); //true
        System.out.println(s.oneEditAway("ab","bc")); //false
        String s1 = "";
    }

}
