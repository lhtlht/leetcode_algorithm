package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution752 {
    public String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] ++;
        }
        return new String(ch);
    }

    public String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] --;
        }
        return new String(ch);
    }


    public int openLock(String[] deadends, String target) {
        //记录死亡密码
        Set<String> deads = new HashSet<String>();
        for (String d:deadends) {
            deads.add(d);
        }

        //记录穷举过的元素
        Set<String> visited = new HashSet<String>();

        Queue<String> q = new LinkedList<String>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i=0; i<sz; i++) {
                String cur = q.poll();
                if ( deads.contains(cur)) {
                    continue;  //判断是够碰到死亡密码
                }
                if ( cur.equals(target)) return step; //结束条件
                for (int j=0; j<4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step ++;
        }

        return -1;
    }


    //双向bfs
    public int openLock2(String[] deadends, String target) {
        //记录死亡密码
        Set<String> deads = new HashSet<String>();
        for (String d:deadends) {
            deads.add(d);
        }

        //记录穷举过的元素
        Set<String> visited = new HashSet<String>();
        //遍历指针
        Set<String> q1 = new HashSet<String>();
        Set<String> q2 = new HashSet<String>();

        q1.add("0000");
        q2.add(target);
        int step = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            //哈希集合在遍历的过程中不能修改，用temp存储扩散结果
            Set<String> temp = new HashSet<String>();
            //扩散q1
            for (String cur:q1) {
                if (deads.contains(cur)) continue;
                if (q2.contains(cur)) return step;
                visited.add(cur);

                for (int j=0; j<4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) temp.add(up);

                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) temp.add(down);
                }
            }
            step ++;
            q1 = q2; //交换遍历
            q2 = temp;
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        String[] deadends1 = {"8888"};
        String target1 = "0009";


        Solution752 s = new Solution752();
        System.out.println(s.openLock2(deadends, target)); //6
        System.out.println(s.openLock(deadends1, target1)); //1
    }
}
