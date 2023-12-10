class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] visit = new int[V];
        Arrays.fill(visit,-1);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(visit[i] == -1){
                q.add(i);
                visit[i] = 0;
                if(check(q,adj,visit) == false){
                    return false;
                }
            }
        }
        return true;
        
        
    }
    public boolean check(Queue<Integer> q,ArrayList<ArrayList<Integer>> adj,int[] visit){
        while(!q.isEmpty()){
            int cur = q.remove();
            for(int neighbour: adj.get(cur)){
                if(visit[neighbour] == -1){
                    visit[neighbour] = 1-visit[cur];
                    q.add(neighbour);
                }else if(visit[neighbour] == visit[cur]){
                    return false;
                }
            }
        }
        return true;
    }
}