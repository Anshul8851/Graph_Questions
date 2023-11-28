class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && grid[i][j] == 1 ){
                    DFS(n,m,visit,grid,i,j);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && !visit[i][j]) ans++;
            }
        }
        return ans;
    }
    public void DFS(int n,int m,boolean[][] visit,int[][] grid,int sr,int sc){
        visit[sr][sc] = true;
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};
        for(int i = 0;i<4;i++){
            int nr = dr[i] + sr;
            int nc = dc[i] + sc;
            if((nr>=0 && nr<n) && (nc>=0 && nc<m) && !visit[nr][nc] && grid[nr][nc] == 1){
                DFS(n,m,visit,grid,nr,nc);
            }
        }
    }
}