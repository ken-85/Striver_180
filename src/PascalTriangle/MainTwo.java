package PascalTriangle;
import java.util.*;

public class MainTwo {
    static Scanner sc=new Scanner(System.in);

    public int findNum(int r, int c){
        int res=1;
        for(int i=1; i<c; i++){
            res*=(r-i);
            res/=i;
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println("Enter the pascal triangle row:");
        int r=sc.nextInt();
        System.out.println("Enter the pascal triangle column:");
        int c=sc.nextInt();
        MainTwo obj=new MainTwo();

        int res=obj.findNum(r,c);
        System.out.println("The "+r+" row's "+c+" column's element is: "+res);
    }
}
