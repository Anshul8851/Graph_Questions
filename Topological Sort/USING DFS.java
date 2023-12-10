class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] visit = new boolean[V];
        Stack<Integer> s1 = new Stack<>();
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                DFS(i,adj,visit,s1);
            }
        }
        
        int[] ans = new int[s1.size()];
        int i = 0;
        while(!s1.isEmpty()){
            ans[i++] = s1.pop();
        }
        return ans;
    }
    public static void DFS(int cur,ArrayList<ArrayList<Integer>> adj,boolean[] visit,Stack<Integer> s1){
        visit[cur] = true;
        for(int neighbour: adj.get(cur)){
            if(!visit[neighbour]){
                DFS(neighbour,adj,visit,s1);
            }
        }
        s1.push(cur);
    }
}