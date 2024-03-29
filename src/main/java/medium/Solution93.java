package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    /*
    93. 复原IP地址
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

    有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

    例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。



    示例 1：

    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]
    示例 2：

    输入：s = "0000"
    输出：["0.0.0.0"]
    示例 3：

    输入：s = "1111"
    输出：["1.1.1.1"]
    示例 4：

    输入：s = "010010"
    输出：["0.10.0.10","0.100.1.0"]
    示例 5：

    输入：s = "101023"
    输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */
    int segs = 4;
    List<String> ans = new ArrayList<String>();
    int[] seg = new int[segs];

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return ans;
    }

    public void backtrack(String s, int segId, int segStart) {
        if (segId == 4) {
            if (segStart == s.length()) { //符合条件
                StringBuffer ip = new StringBuffer();
                for (int i=0; i<4; i++) {
                    ip.append(seg[i]);
                    if (i != 3) {
                        ip.append(".");
                    }
                }
                ans.add(ip.toString());
            }
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            seg[segId] = 0;
            backtrack(s, segId+1, segStart+1);
        }

        int curr = 0;
        for (int i=segStart; i<s.length(); i++) {
            curr = curr * 10 + (s.charAt(i)-'0');
            if (curr > 0 && curr <= 255) {
                seg[segId] = curr;
                backtrack(s, segId+1, i+1);
            } else {
                break;
            }
        }

    }

    public static void main(String[] args) {
        Solution93 s = new Solution93();
        System.out.println(s.restoreIpAddresses("25525511135"));
        System.out.println(s.restoreIpAddresses("0000"));
        System.out.println(s.restoreIpAddresses("1111"));
        System.out.println(s.restoreIpAddresses("101023"));
    }
}
