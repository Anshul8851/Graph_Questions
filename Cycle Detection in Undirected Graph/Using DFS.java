class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visit = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                if(DFS(adj,i,visit,-1) == true) return true;
            }
        }
        return false;
    }
    public boolean DFS(ArrayList<ArrayList<Integer>> adj,int cur,boolean[] visit,int parent){
        visit[cur] = true;
        for(int neighbour: adj.get(cur)){
            if(!visit[neighbour]){
                if(DFS(adj,neighbour,visit,cur) == true) return true;
            }else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }
}