class Solution {
    // Function to detect cycle in an undirected graph.
    public class pair{
        int r;
        int p;
        pair(int r,int p){
            this.r = r;
            this.p = p;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visit = new boolean[V];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                q.add(new pair(i,-1));
                visit[i] = true;
                if(BFS(q,adj,visit) == true) return true;
            }
        }
        return false;
    }
    public boolean BFS(Queue<pair> q,ArrayList<ArrayList<Integer>> adj,boolean[] visit){
        while(!q.isEmpty()){
            pair cur = q.remove();
            for(int neighbour: adj.get(cur.r)){
                if(!visit[neighbour]){
                    q.add(new pair(neighbour,cur.r));
                    visit[neighbour] = true;
                    if(BFS(q,adj,visit) == true) return true;
                }else if(neighbour != cur.p){
                    return true;
                }
            }
        }
        return false;
    }
}