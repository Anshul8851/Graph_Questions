class Solution
{ 
    public class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n = image.length;
        int m = image[0].length;
        boolean[][] visit = new boolean[n][m];
        int[][] newimg = new int[n][m];
        bfs(sr,sc,image,newColor,visit,n,m);
        return image;
    }
    public void bfs(int i,int j,int[][] img,int color,boolean[][] visit,int n,int m){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,j));
        int icolor = img[i][j];
        img[i][j] = color;
        visit[i][j] = true;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!q.isEmpty()){
            pair cur = q.poll();
            int curr = cur.row;
            int curc = cur.col;
            for(int y = 0;y<4;y++){
                int nr = curr+dr[y];
                int nc = curc+dc[y];
                if((nr>=0 && nr<n) && (nc>=0 && nc<m) && img[nr][nc] == icolor && !visit[nr][nc]){
                    q.add(new pair(nr,nc));
                    visit[nr][nc] = true;
                    img[nr][nc] = color;
                }
            }
            
        }
    }
}
