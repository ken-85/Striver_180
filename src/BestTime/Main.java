package BestTime;

import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);

    public int maxPro(int[] arr, int n){
        int minPri=Integer.MAX_VALUE;
        int maxPro=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            minPri=Math.min(minPri, arr[i]);
            maxPro=Math.max(maxPro, arr[i]-minPri);
        }

        return maxPro;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of days:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the price in each day:");
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        Main obj=new Main();
        int res=obj.maxPro(arr,n);
        System.out.println("The maximum profit is: "+res);
    }
}
