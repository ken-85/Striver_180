package PascalTriangle;

import java.util.*;

public class MainOne {
    static Scanner sc=new Scanner(System.in);

    public void printTri(int n){
        int ans=1;
        System.out.print(ans+" ");
        for(int i=1; i<n; i++){
            ans=ans*(n-i);
            ans=ans/i;
            System.out.print(ans+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the nth row of Pascal triangle to be printed:");
        int n=sc.nextInt();
        MainOne obj=new MainOne();
        System.out.println("The "+n+"th pascal triangle row is:");
        obj.printTri(n);
    }
}
