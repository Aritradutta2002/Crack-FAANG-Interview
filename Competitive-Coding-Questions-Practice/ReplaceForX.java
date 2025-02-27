import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class ReplaceForX {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int x=Integer.parseInt(t1.nextToken());
            int p=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            StringTokenizer t2=new StringTokenizer(r.readLine());
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t2.nextToken());
            Arrays.sort(array);
            p--;
            k--;
            if(array[p]==x)
                System.out.println(0);
            else if(k>=p&&array[p]>=x){
                int count=0;
                for(int i=p;i>=0;i--){
                    if(array[i]==x)
                        break;
                    if(array[i]<x){
                        // count++;
                        break;
                    }
                    count++;
                }
                System.out.println(count);
            }
            else if(p>=k&&array[p]<=x){
                int count=0;
                for(int i=p;i<n;i++){
                    if(array[i]==x)
                        break;
                    if(array[i]>x){
                        // count++;
                        break;
                    }
                    count++;
                }
                System.out.println(count);
            }
            else
                System.out.println(-1);
        }
    } 
}
