class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visit = new boolean[V];
        boolean[] pvisit = new boolean[V];
        
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                if(dfs(i,adj,visit,pvisit) == true) return true;
            }
        }
        return false;
    }
    public boolean dfs(int cur,ArrayList<ArrayList<Integer>> adj,boolean[] visit,boolean[] pvisit){
        visit[cur] = true;
        pvisit[cur] = true;
        
        for(int neighbour : adj.get(cur)){
            if(!visit[neighbour]){
                if(dfs(neighbour,adj,visit,pvisit) == true) return true;
            }else if(pvisit[neighbour] == true) return true;
        }
        pvisit[cur] = false;
        return false;
    }
}