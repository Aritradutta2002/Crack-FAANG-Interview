import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class ChefAndWork {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]aa=r.readLine().split(" ");
            int n=Integer.parseInt(aa[0]);
            int k=Integer.parseInt(aa[1]);
            String[]data=r.readLine().split(" ");
            long[]array=new long[n];
            long sum=0;
            int count=1;
            for(int i=0;i<n;i++)
                array[i]=Long.parseLong(data[i]);
            for(long i:array){
                if(i>k){
                    count=-1;
                    break;
                }
                if(sum+i>k){
                    sum=i;
                    count++;
                }
                else{
                    sum+=i;
                }
            }
            System.out.println(count);
        }
    } 
}