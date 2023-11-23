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
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                visit[i] = true;
                q.add(i);
                ans += BFS(q,visit,adj1);
            }
        }
        return ans;
    }
    public static int BFS(Queue<Integer> q,boolean[] visit,ArrayList<ArrayList<Integer>> adj){
        while(!q.isEmpty()){
            int cur = q.remove();
            for(int neighbour: adj.get(cur)){
                if(!visit[neighbour]){
                    visit[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return 1;
    }
}