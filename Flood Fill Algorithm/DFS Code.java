class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n = image.length;
        int m = image[0].length;
        boolean[][] visit = new boolean[n][m];
        DFS(sr,sc,image[sr][sc],visit,image,newColor,n,m);
        return image;
    }
    public void DFS(int sr,int sc,int oc,boolean[][] visit,int[][] image,int newColor,int n,int m){
        visit[sr][sc] = true;
        image[sr][sc] = newColor;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i = 0;i<4;i++){
            int nr = sr+dr[i];
            int nc = sc+dc[i];
            if((nr>=0 && nr<n) && (nc>= 0 && nc<m) && !visit[nr][nc] && image[nr][nc] == oc){
                DFS(nr,nc,oc,visit,image,newColor,n,m);
            }
        }
    } 
}
