package bipartite;
import java.util.*;

public class Main{
    static Scanner sc=new Scanner(System.in);

    private boolean checkNode(int start, int[] color, List<List<Integer>> adj){
        color[start]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();

            for(int it:adj.get(node)){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkGraph(List<List<Integer>> adj, int n){
        int[] color=new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(checkNode(i,color,adj)==false) return false;
            }
        }

        return true;
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
            boolean res=obj.checkGraph(adj, n);
            if(res) System.out.println("Bipartite Graph");
            else System.out.println("Not Bipartite Graph");
   
    }
}


