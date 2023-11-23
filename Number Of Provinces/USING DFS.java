class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj1.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                if(i!=j && adj.get(i).get(j) == 1){
                    adj1.get(i).add(j);
                    adj1.get(j).add(i);
                }
            }
        }
        boolean[] visit = new boolean[V];
        int ans = 0;
        for(int i = 0;i<V;i++){
            if(!visit[i]){
               ans+= DFS(i,visit,adj1);
            }
        }
        return ans;
    }
    static int DFS(int cur,boolean[] visit,ArrayList<ArrayList<Integer>> adj){
        visit[cur] = true;
        for(int neighbour: adj.get(cur)){
            if(!visit[neighbour]){
                DFS(neighbour,visit,adj);
            }
        }
        return 1;
        
    }
}