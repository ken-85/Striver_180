package PascalTriangle;
import java.util.*;

public class MainThree {
    static Scanner sc=new Scanner(System.in);
    
    public static List<Integer> genRow(int row){
        List<Integer> li=new ArrayList<>();
        li.add(1);
        long ans=1;

        for(int i=1; i<row; i++){
            ans*=(row-i);
            ans/=i;
            li.add((int) ans);
        }

        return li;
    }
    public static List<List<Integer>> pascalTri(int n){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1; i<=n; i++){
            ans.add(genRow(i));
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter till what row you want the Pascal's triangle:");
        int n=sc.nextInt();
        List<List<Integer>> res=pascalTri(n);
        System.out.println("The pascal's triangle upto "+n+" row is:");
        for(int i=0; i<res.size(); i++){
            for(int j=0; j<res.get(i).size(); j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
