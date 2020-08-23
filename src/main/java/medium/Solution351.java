package medium;

public class Solution351 {
    /*
    351. 安卓系统手势解锁
    我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。

    给你两个整数，分别为 ​​m 和 n，其中 1 ≤ m ≤ n ≤ 9，那么请你统计一下有多少种解锁手势，是至少需要经过 m 个点，但是最多经过不超过 n 个点的。



    先来了解下什么是一个有效的安卓解锁手势:

    每一个解锁手势必须至少经过 m 个点、最多经过 n 个点。
    解锁手势里不能设置经过重复的点。
    假如手势中有两个点是顺序经过的，那么这两个点的手势轨迹之间是绝对不能跨过任何未被经过的点。
    经过点的顺序不同则表示为不同的解锁手势。
     */

    //并查集
    int ans = 0;
    boolean[] marked = new boolean[10];
    UnionFind uf = new UnionFind(10);
    public int numberOfPatterns(int m, int n) {
        initializedUF();
        for (int i=1; i<10; i++) {
            dfs(i, 1, m, n);
        }
        return ans;
    }

    public void dfs(int s, int currentKeyCount, int lo, int hi) {
        if (currentKeyCount >= lo && currentKeyCount <= hi) {
            ans++;
        } else if (currentKeyCount > hi) {
            return;
        }

        marked[s] = true;
        for (int i=1; i<10; i++) {
            boolean crossNumber = uf.connected(s, i); //是否统一分支
            if (!marked[i] && (!crossNumber || marked[(s+i)>>>1])) {
                dfs(i, currentKeyCount+1, lo, hi);
            }
        }
        marked[s] = false;


    }

    private void initializedUF() {
        uf.union(1,3);
        uf.union(1,9);
        uf.union(1,7);
        uf.union(4,6);
        uf.union(2,8);
    }

    public class UnionFind {
        int[] parent;
        public UnionFind(int count) {
            parent = new int[count];
            for (int i=0; i<count; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;

        }
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            parent[qRoot] = parent[pRoot];
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        Solution351 s = new Solution351();
        //System.out.println(s.numberOfPatterns(1,1)); //9
        System.out.println(s.numberOfPatterns(4,5)); //8776
    }
}
