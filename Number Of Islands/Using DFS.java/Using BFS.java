class Solution {
    
    public class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        int island = 0;
        Queue<pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visit[i][j] && grid[i][j] == '1'){
                    island++;
                    q.add(new pair(i,j));
                    visit[i][j] = true;
                    BFS(q,grid,visit,n,m);
                }
            }
        }
        return island;
    }
    public void BFS(Queue<pair> q,char[][] grid,boolean[][] visit,int n,int m){
        while(!q.isEmpty()){
            pair cur = q.remove();
            for(int i = -1;i<=1;i++){
                for(int j = -1;j<=1;j++){
                    int nr = cur.r+i;
                    int nc = cur.c+j;
                    if((nr>=0 && nr<n) && (nc>=0 && nc < m) && !visit[nr][nc] && grid[nr][nc] == '1'){
                        q.add(new pair(nr,nc));
                        visit[nr][nc] = true;
                    }
                }
            }
        }
    }
    
    
    
    
}