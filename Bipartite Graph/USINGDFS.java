class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color,-1);
        
        for(int i = 0;i<V;i++){
            if(color[i] == -1){
                if(dfs(i,color,adj,0) == false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int cur,int[] color,ArrayList<ArrayList<Integer>> adj,int pc){
        color[cur] = pc;
        for(int neighbour:adj.get(cur)){
            if(color[neighbour] == -1){
                if (dfs(neighbour,color,adj,1-color[cur]) == false) return false;
            }else if(color[neighbour] == pc){
                return false;
            }
        }
        return true;
    }
}