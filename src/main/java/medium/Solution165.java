package medium;

public class Solution165 {
    /*
    165. 比较版本号
    比较两个版本号 version1 和 version2。
    如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

    你可以假设版本字符串非空，并且只包含数字和 . 字符。

     . 字符不代表小数点，而是用于分隔数字序列。

    例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

    你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
     */

    public int compareVersion(String version1, String version2) {
        String[] currV1 = version1.split("\\.");
        String[] currV2 = version2.split("\\.");
        int len1 = currV1.length;
        int len2 = currV2.length;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (Integer.parseInt(currV1[i]) > Integer.parseInt(currV2[j])) {
                return 1;
            } else if (Integer.parseInt(currV1[i]) < Integer.parseInt(currV2[j])) {
                return -1;
            } else {
                i++;
                j++;
            }
        }

        while (i < len1) {
            if (Integer.parseInt(currV1[i]) == 0) {
                i++;
            } else {
                return 1;
            }
        }
        while (j < len2) {
            if (Integer.parseInt(currV2[j]) == 0) {
                j++;
            } else {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution165 s = new Solution165();
        System.out.println(s.compareVersion("0.1", "1.1")); //-1
        System.out.println(s.compareVersion("1.0.1", "1")); //1
        System.out.println(s.compareVersion("7.5.2.4", "7.5.3")); //-1
    }
}
