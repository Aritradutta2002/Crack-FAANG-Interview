import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ChefAndEasyQueries {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            StringTokenizer t2=new StringTokenizer(r.readLine());
            int[]array=new int [n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t2.nextToken());
            long total=0;
            boolean found=false;
            for(int i=0;i<n;i++){
                total+=array[i];
                long diff=Math.min(total, k);
                if(diff<k){
                    System.out.println((i+1));
                    found=true;
                    break;
                }
                total-=diff;
            }
            if(!found)
                System.out.println((total/k+n+1));
            
        }
    } 
}
