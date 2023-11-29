class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n  = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visit[i][j] && grid[i][j] == 1){
                    ArrayList<Integer> list = new ArrayList<>();
                    DFS(i,j,visit,grid,list,i,j);
                     set.add(list);
                }
            }
        }
       
        return set.size();
    }
    void DFS(int sr,int sc,boolean[][] visit,int[][] grid,ArrayList<Integer> list,int k,int l){
        visit[sr][sc] = true;
        list.add(k-sr);
        list.add(l-sc);
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i = 0;i<4;i++){
            int nr = dr[i]+sr;
            int nc = dc[i]+sc;
            if((nr>=0 && nr< grid.length) && (nc>=0 && nc < grid[0].length) && !visit[nr][nc] && grid[nr][nc] == 1){
                DFS(nr,nc,visit,grid,list,k,l);
            }
        }
    }
}
