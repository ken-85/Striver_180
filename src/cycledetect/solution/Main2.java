package cycledetect.solution;

import java.util.*;
public class Main2 {
    static Scanner sc=new Scanner(System.in);

    private boolean dfs(int node, int parent, boolean[] vis, List<List<Integer>> adj){
        vis[node]=true;

        for(int it:adj.get(node)){
            if(!vis[it]){
                if(dfs(it,node,vis,adj)==true) return true;
            }

            else if(it!=node){
                return true;
            }
        }

        return false;
    }

    public boolean detectCycle(List<List<Integer>> adj){
        boolean[] vis=new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                if(dfs(i,-1,vis,adj)==true) return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of nodes");
        int n=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            System.out.println("Enter the number of neighbours of node "+(i));
            int neighbours=sc.nextInt();
            System.out.println("Enter neighbours of node "+(i));
            for(int j=0; j<neighbours; j++) adj.get(i).add(sc.nextInt());
        }

        Main obj=new Main();
        boolean res=obj.detectCycle(adj);
        if(res) System.out.println("Cycle detected");
        else System.out.println("Cycle not detected");
    }
}
