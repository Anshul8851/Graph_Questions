class Solution {
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visit = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
                q.add(0);
                visit[0] = true;
                while(!q.isEmpty()){
                    int cur = q.remove();
                    ans.add(cur);
                    for(int i = 0;i<adj.get(cur).size();i++){
                        if(!visit[adj.get(cur).get(i)]){
                            visit[adj.get(cur).get(i)] = true;
                            q.add(adj.get(cur).get(i));
                        }
                    }
                }
        
        return ans;
    }
}