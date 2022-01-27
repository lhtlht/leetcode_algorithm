package jz;

public class JZ13 {
    public int movingCount(int m, int n, int k) {
        /*
        (x+1)%10=0,s(x+1)=s(x)-8
        (x+1)%10!=0,s(x+1)=s(x)+1
         */
        boolean[][] visited = new boolean[m][n];
        return dfs(m,n,k,visited,0,0,0,0);
    }

    public int dfs(int m, int n, int k, boolean[][] visited, int i, int j, int si, int sj){
        if(i>=m || j>=n || k<si+sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 +
                dfs(m,n,k,visited,i+1,j,(i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(m,n,k,visited,i,j+1,si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);


    }
}
