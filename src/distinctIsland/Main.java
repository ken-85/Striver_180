package distinctIsland;
import java.util.*;

public class Main{
    static Scanner sc=new Scanner(System.in);
    private final int[] numRow={-1,0,1,0};
    private final int[] numCol={0,-1,0,1};

    private String toString(int r, int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    private void dfs(int row, int col, int[][] matrix, boolean[][] vis, List<String> ds, int row0, int col0){
        vis[row][col]=true;
        ds.add(toString(row-row0, col-col0));
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0; i<4; i++){
            int newRow=row+numRow[i];
            int newCol=col+numCol[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]==false && matrix[newRow][newCol]==1){
                dfs(newRow, newCol, matrix, vis, ds, row0, col0);
            }
        }
        
    }

    public int findDistinct(int[][] matrix){
        boolean[][] vis=new boolean[matrix.length][matrix[0].length];

        for(boolean[] rows:vis){
            Arrays.fill(rows, false);
        }

        Set<List<String>> res=new HashSet<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(vis[i][j]==false && matrix[i][j]==1){
                    List<String> ds=new ArrayList<>();
                    dfs(i,j,matrix,vis,ds,i,j);
                    res.add(ds);
                }
            }
        }

        return res.size();
    }
    public static void main(String[] args) {
        System.out.println("Enter number of test cases");
        int t=sc.nextInt();
        while(t>0){
            System.out.println("Enter the row size of matrix:");
            int n=sc.nextInt();
            System.out.println("Enter the column size of matrix:");
            int m=sc.nextInt();

            int[][] matrix=new int[n][m];

            System.out.println("Enter elemnts of matrix(only 0s and 1s)");
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++) matrix[i][j]=sc.nextInt();
            }

            Main obj=new Main();

            int res=obj.findDistinct(matrix);
            System.out.println("Number of distinct island="+res);
            t--;
        }
    }
}

