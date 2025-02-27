import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 class MaximumCandies {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            StringTokenizer t=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t.nextToken());
            int m=Integer.parseInt(t.nextToken());
            int x=Integer.parseInt(t.nextToken());
            int y=Integer.parseInt(t.nextToken());
            long max=-1;
            for(int i=0;i<=x;i++){
                long a1=((m*n)/2+(m*n)%2)*Math.min(i,y)+((m*n)/2)*Math.max(0, y-Math.min(i,y));
                long a2=((m*n)/2)*Math.min(i,y)+((m*n)/2+(m*n)%2)*Math.max(0, y-Math.min(i,y));
                max=Math.max(max, a1);
                max=Math.max(max, a2);

            }
            System.out.println(max);

        }
    } 
}
