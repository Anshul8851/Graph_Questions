class Solution {
    public class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r  = r;
            this.c =  c;
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && grid[i][j] == 1 && !visit[i][j]){
                    visit[i][j] = true;
                    q.add(new pair(i,j));
                    BFS(q,visit,grid,n,m);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visit[i][j] && grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void BFS(Queue<pair> q,boolean[][] visit,int[][] grid,int n,int m){
        int[] dr = {0,0,1,-1};
        int[] dc = {-1,1,0,0};
        while(!q.isEmpty()){
            pair cur = q.remove();
            for(int i = 0;i<4;i++){
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                if((nr>= 0 && nr<n ) && (nc>=0 && nc<m) && !visit[nr][nc] && grid[nr][nc] == 1){
                    visit[nr][nc] = true;
                    q.add(new pair(nr,nc));
                }
            }
        }
    }

}