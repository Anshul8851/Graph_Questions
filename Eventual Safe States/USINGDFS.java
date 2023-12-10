class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> ans = new ArrayList<Integer>();
        boolean[] visit = new boolean[V];
        boolean[] pvisit = new boolean[V];
        boolean[] check = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                DFS(i,visit,pvisit,ans,check,adj);
            }
        }
        for(int i = 0;i<V;i++){
            if(check[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean DFS(int cur,boolean[] visit,boolean[] pvisit,List<Integer> ans,boolean[] check,List<List<Integer>> adj){
        visit[cur] = true;
        pvisit[cur] = true;
        check[cur] = false;
        for(int neighbour: adj.get(cur)){
            if(!visit[neighbour]){
                if(DFS(neighbour,visit,pvisit,ans,check,adj) == true){
                    check[cur] = false;
                    return true;
                }
            }else if(pvisit[neighbour]){
                return true;
            }
        }
        check[cur] = true;
        pvisit[cur] = false;
        return false;
    }
}

