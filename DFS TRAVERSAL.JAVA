class Solution {
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visit = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                DFS(i,ans,visit,adj);
            }
        }
        return ans;
    }
    public void DFS(int cur,ArrayList<Integer> ans,boolean[] visit,ArrayList<ArrayList<Integer>> adj){
        visit[cur] = true;
        ans.add(cur);
        for(int  neighbour : adj.get(cur)){
            if(!visit[neighbour]){
                DFS(neighbour,ans,visit,adj);
            }
        }
    }
}