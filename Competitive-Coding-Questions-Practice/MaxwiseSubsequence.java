import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class MaxwiseSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=Integer.parseInt(data[i]);
            }
            boolean[]taken=new boolean[n];
            int left=0;
            int right=n-1;
            while(left<right){
                if(array[left]>=0)
                    left++;
                else if(array[left]<0&&array[right]>=0){
                    taken[left]=true;
                    taken[right]=true;
                    int temp=array[right];
                    array[right]=array[left];
                    array[left]=temp;
                    left++;
                    right--;
                }
                else
                    right--;
            }
            long sum=0;
            long max=0;
            for (int i:array){
                if(i<0)
                    break;
                sum+=i;
            }
            max=sum;
            // for(int i:array)
            //     System.out.print(i+" ");
            // System.out.println();
            System.out.println(max);
            if(max==0){
                System.out.println(0);
                continue;
            }
            for(int i=0;i<n;i++){
                if(taken[i])
                    System.out.print((i+1)+" ");
            }
            System.out.println();
        } 
    } 
}
