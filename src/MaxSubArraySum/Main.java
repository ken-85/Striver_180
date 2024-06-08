package MaxSubArraySum;
import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);

    public long findMaxSum(long[] arr, long n){
        long sum=0;
        long maxSum=Long.MIN_VALUE;

        for(long i=0; i<n; i++){
            sum+=arr[(int) i];
            maxSum=Math.max(sum, maxSum);
            if(sum<0){
                sum=0;
            }  
        }

        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println("Enter length of array:");
        long n=sc.nextLong();
        long[] arr=new long[(int) n];

        System.out.println("Enter array elements:");
        for(int i=0; i<n; i++){
            arr[i]=sc.nextLong();
        }

        Main obj=new Main();

        long res=obj.findMaxSum(arr, n);
        System.out.println("The sum of maximum subarray is: "+res);
    }
}
