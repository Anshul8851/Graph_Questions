class Solution {
    public class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && !visit[i][j] && board[i][j] == 'O'){
                    visit[i][j] = true;
                    q.add(new pair(i,j));
                    
                }
            }
        }
        BFS(q,n,m,visit,board);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visit[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void BFS(Queue<pair> q,int n,int m,boolean[][] visit,char[][] board){
        while(!q.isEmpty()){
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            pair cur = q.remove();
            for(int i = 0;i<4;i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if((nr>=0 && nr<n) && (nc>=0 && nc<m) && !visit[nr][nc] && board[nr][nc] == 'O'){
                    visit[nr][nc] = true;
                    q.add(new pair(nr,nc));
                }
            }
        }
    }
}