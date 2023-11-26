class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public class pair{
        int r;
        int c;
        int s;
        pair(int r,int c,int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int[][] dis = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    visit[i][j] = true;
                    q.add(new pair(i,j,0));
                }
            }
        }
        BFS(q,visit,n,m,dis);
        return dis;
    }
    public void BFS(Queue<pair> q,boolean[][] visit,int n,int m,int[][] dis){
        
        while(!q.isEmpty()){
            pair cur = q.remove();
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            for(int i = 0;i<4;i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if((nr>= 0 && nr<n) && (nc>=0 && nc<m) && !visit[nr][nc]){
                    visit[nr][nc] = true;
                    dis[nr][nc] = cur.s+1;
                    q.add(new pair(nr,nc,cur.s+1));
                }
            }
        }
        
    }
}