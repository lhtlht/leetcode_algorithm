package medium;

import java.util.LinkedList;

public class Solution71 {
    /*
    71. 简化路径
    以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
    在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
    更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
    请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。



    示例 1：

    输入："/home/"
    输出："/home"
    解释：注意，最后一个目录名后面没有斜杠。
     */
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        int i = 0;
        int n = path.length();
        while (i < n) {
            StringBuffer tmp = new StringBuffer();
            while (i<n && path.charAt(i) == '/') {
                i++;
            }
            while (i<n && path.charAt(i) != '/') {
                tmp.append(path.charAt(i));
                i++;
            }
            String p = tmp.toString();
            if (p.length() > 0) {
                if (p.equals("..")){
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                } else if (p.equals(".")) {
                    continue;
                } else {
                    stack.add(p);
                }
            }


        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans += "/"+stack.poll();
        }
        return ans == ""? "/":ans;
    }

    public static void main(String[] args) {
        Solution71 s = new Solution71();
//        System.out.println(s.simplifyPath("/home/")); //"/home"
//        System.out.println(s.simplifyPath("/../")); // "/"
//        System.out.println(s.simplifyPath("/home//foo/")); // "/home/foo"
//        System.out.println(s.simplifyPath("/a/./b/../../c/")); //  "/c"
//        System.out.println(s.simplifyPath("/a/../../b/../c//.//")); // "/c"
        System.out.println(s.simplifyPath("/a//b////c/d//././/..")); // "/a/b/c"
    }
}
