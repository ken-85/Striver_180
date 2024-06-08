package NextPermutation;
import java.util.*;
public class Main {
    static Scanner sc=new Scanner(System.in);

    public static void reverse(List<Integer> li){
        int start=0;
        int end=li.size()-1;
        while(start<end){
            switchNum(li, start, end);
            start++;
            end--;
        }
    }


    public static void reverse(List<Integer> li, int i, int j){
        while(i<=j){
            switchNum(li, i, j);
            i++;
            j--;
        }
    }
    public static void switchNum(List<Integer> li, int i, int j){
        int temp=li.get(i);
        li.set(i, li.get(j));
        li.set(j, temp);
    }

    public static List<Integer> findPerm(List<Integer> li){
        int index=-1;
        int i=li.size()-2;

        while(i>=0){
            if(li.get(i)<li.get(i+1)){
                index=i;
                break;
            }
            i--;
        }
        if(index==-1){
            reverse(li);
        }
        int j=li.size()-1;

        while(j>=index){
            if(li.get(j)>li.get(index)){
                switchNum(li, index, j);
                break;
            }
            j--;
        }
    
        reverse(li, index+1, li.size()-1);

        return li;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        long n=sc.nextLong();
        List<Integer> li=new ArrayList<>();
        while(n>0){
            int temp=(int) n%10;
            li.add(temp);
            n/=10;
        }
        Collections.reverse(li);
        List<Integer> res=findPerm(li);
        System.out.println("The next big permutation is:");
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i));
        }
    }
}
