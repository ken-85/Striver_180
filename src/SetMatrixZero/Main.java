package SetMatrixZero;
import java.util.*;

class Main{
    static Scanner sc=new Scanner(System.in);

    public void setMatrixZero(int[][] matrix){
        int col0=1;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }
                    else{
                        col0=0;
                    }
                }
            }
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }

        if(col0==0){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0]=0;
            }
        }

        System.out.println("The modified matrix is:");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter number of test cases");
        int t=sc.nextInt();
        while(t>0){
            System.out.println("Enter the number of rows and columns (nXn)");
            int n=sc.nextInt();
    
            int[][] matrix=new int[n][n];
            System.out.println("Enter matrix elements (only 0's and 1's)");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            System.out.println("The original matrix:");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                   System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }

            Main obj=new Main();

            obj.setMatrixZero(matrix);
            t--;
        }
      
    }
}