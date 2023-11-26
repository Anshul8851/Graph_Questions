class Solution {
    public class Pair{
        int r;
        int c;
        int t;
        Pair(int r,int c,int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0 ;j< m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visit[i][j] = true;
                }
            }
        }
        int t = BFS(q,visit,grid,n,m);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return t;
    }
    public int BFS(Queue<Pair> q,boolean[][] visit,int[][] grid,int n,int m){
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int time = 0;
        while(!q.isEmpty()){
            Pair cur = q.remove();
            time = cur.t;
            for(int i = 0;i<4;i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if((nr>= 0 && nr < n) && (nc>=0 && nc<m) && !visit[nr][nc] && grid[nr][nc] == 1){
                    q.add(new Pair(nr,nc,cur.t+1));
                    grid[nr][nc] = 2;
                    visit[nr][nc] = true;
                }
            }
        }
        return time;
    }
}