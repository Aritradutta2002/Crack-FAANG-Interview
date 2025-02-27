import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 class CovidSpread {
    static double[][]times;
    static int getCount(boolean[]visited,double time,int pos,int n){
        visited[pos]=true;
        int count=1;
        // System.out.println("~~");
        for(int i=0;i<n;i++)
            if(times[pos][i]!=Double.MIN_VALUE&&times[pos][i]>=time&&!visited[i]){
                // count-=added[pos];
                // System.out.println(times[pos][i]+" "+time );
                count+=getCount(visited, times[pos][i],i, n);
                // count+=added[pos];
            }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split(" ");
            int[]array=new int [n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            times =new double[n][n];
            for(double[]a:times)
                Arrays.fill(a, Double.MIN_VALUE);
            
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++)
                    if(array[j]>array[i]){
                        times[j][i]=(double)(i-j)/(double)(array[j]-array[i]);
                        times[i][j]=(double)(i-j)/(double)(array[j]-array[i]);
                    }
                for(int j=i+1;j<n;j++){
                    if(array[i]>array[j]){
                        times[j][i]=(double)(j-i)/(double)(array[i]-array[j]);
                        times[i][j]=(double)(j-i)/(double)(array[i]-array[j]);
                    }
                }
            }
            int max=1;
            int min=n;
            // for(double[]a:times){
            //     for(double j:a)
            //         System.out.print(j+" ");
            //     System.out.println();
            // }
            for(int i=0;i<n;i++){
                int ans=getCount(new boolean[n],0, i, n);
                // System.out.println(i+" "+ans);
                max=Math.max(max, ans);
                min=Math.min(min, ans);
            }
            System.out.println(min+" "+max);

        }
    } 
}
