class Solution {
    // Function to find the nu
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int island = 0;
        boolean[][] visit = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !visit[i][j]){
                    island++;
                    DFS(grid,visit,i,j,n,m);
                }
            }
        }
        return island;
    }
    public void DFS(char[][] grid,boolean[][] visit,int sr,int sc,int n,int m){
        visit[sr][sc] = true;
        for(int i = -1;i<=1;i++){
            for(int j = -1;j<=1;j++){
                int nr = sr+i;
                int nc = sc+j;
                if((nr>=0 && nr<n) && (nc>=0 && nc<m) && !visit[nr][nc] && grid[nr][nc] == '1'){
                    DFS(grid,visit,nr,nc,n,m);
                }
            }
        }
    }
}
