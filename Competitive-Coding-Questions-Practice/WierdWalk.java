import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 class WierdWalk {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            int n=Integer.parseInt(r.readLine());
            StringTokenizer t=new StringTokenizer(r.readLine());
            int[]array1=new int[n];
            for(int i=0;i<n;i++)
                array1[i]=Integer.parseInt(t.nextToken());
            
            t=new StringTokenizer(r.readLine());
            int[]array2=new int[n];
            for(int i=0;i<n;i++)
                array2[i]=Integer.parseInt(t.nextToken());
            long count=0;
            int pos1=0;
            int pos2=0;
            for(int i=0;i<n;i++){
                if(pos1==pos2&&array1[i]==array2[i])
                    count+=array1[i];
                pos1+=array1[i];
                pos2+=array2[i];
            }
            System.out.println(count);

        } 
    } 
}
