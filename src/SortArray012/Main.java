package SortArray012;
import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);

    public void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int[] sortArray(int[] arr){
        int low=0;
        int mid=0;
        int high=arr.length-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(arr, low, mid);
                low++;
                mid++;
            }

            else if(arr[mid]==1){
                mid++;
            }

            else{
                swap(arr, mid, high);
                high--;
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        System.out.println("Enter the length of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements (0s, 1s, & 2s): ");
        try{
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
                if(arr[i]!=0 && arr[i]!=1 && arr[i]!=2){
                    throw new Exception("Invalid input");
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Main obj=new Main();
        int[] res=new int[n];
        System.out.println("The sorted array is:");
        res=obj.sortArray(arr);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}
