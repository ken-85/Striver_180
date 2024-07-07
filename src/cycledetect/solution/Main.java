package cycledetect.solution;
import java.util.*;

class Pair{
    int node;
    int parent;

    Pair(int node, int parent){
        this.node=node;
        this.parent=parent;
    }
}

public class Main{
    static Scanner sc=new Scanner(System.in);

    private boolean bfs(int src, int parent, List<List<Integer>> adj, boolean[] vis){
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src, parent));

        while(!q.isEmpty()){
            int currNode=q.peek().node;
            int currParent=q.peek().parent;
            q.remove();

            for(int adjNodes:adj.get(currNode)){
                if(vis[adjNodes]==false){
                    vis[adjNodes]=true;
                    q.add(new Pair(adjNodes, currNode));
                }
                else if(adjNodes!=currParent) return true;
            }
        }

        return false;
    }

    public boolean detectCycle(List<List<Integer>> adj){
        boolean[] vis=new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                if(bfs(i,-1,adj,vis)==true) return true;
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