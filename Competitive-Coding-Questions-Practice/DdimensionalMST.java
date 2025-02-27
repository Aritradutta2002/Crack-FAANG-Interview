import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
  
class DdimensionalMST  
{ 
    static int Prim(int array[][], int d,int V) {
        int count=0;
        int n=V;
        boolean[] visited = new boolean[V];
        visited[0] = true;
        int sum=0;
        int[][]p=new int[n][n];
        boolean[][]b=new boolean[n][n];
        // for(int[]a:p)
        //     Arrays.fill(a, Integer.MAX_VALUE);
        while (count < V - 1) {
          int min = Integer.MAX_VALUE;
            int x = 0;
          int y = 0;
    
          for (int i = 0; i < V; i++) {
            if (visited[i] == true) {
              for (int j = i+1; j < V; j++) {
                int w;
                if(visited[j])
                    continue;
                if(!b[i][j]){
                    w=getDistance(d, array[i], array[j]);
                    p[i][j]=w;
                    p[j][i]=w;
                }
                else
                    w=p[i][j];
                if (min > w) {
                    min = w;
                    x = i;
                    y = j;
                  }
              }
            }
          }
          sum+=min;
          visited[y] = true;
          count++;
        }
        return sum;
      }

    static int getDistance(int d,int[]a1,int[]a2){
        int diff=0;
        for(int i=0;i<d;i++){
            diff+=Math.abs(a1[i]-a2[i]);
            // System.out.println(diff);
        }
        return diff;
    }
    public static void main(String[] args)throws IOException { 
        try{
            BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t=new StringTokenizer(r.readLine());
        int n=Integer.parseInt(t.nextToken());
        int d=Integer.parseInt(t.nextToken());
        int[][]array=new int[n][d];
        for(int i=0;i<n;i++){
            t=new StringTokenizer(r.readLine());
            for(int j=0;j<d;j++)
                array[i][j]=Integer.parseInt(t.nextToken());
        }
        // int[][]weights=new int[n][n] ;
        //         for(int[]a:weights)
        //             Arrays.fill(a, Integer.MIN_VALUE);
        // for(int i=0;i<n;i++)
        //     for(int j=i+1;j<n;j++){
        //         weights[i][j]=getDistance(d, array[i], array[j]);
        //         weights[j][i]=weights[i][j];
        //     }
        // for(int[]i:weights)
        //     Arrays.sort(i);
        // int sum=0;
        // for(int i=0;i<n;i++)
        //     sum+=weights[i][n-1];
        // System.out.println(sum);
        // System.out.println(Math.abs(Prim(array,d, n)));
        int []s=new int[n];
        for(int i=0;i<n;i++){
            int s1=0;
            for(int j=0;j<n;j++)
                s1+=array[i][j];
            s[i]=s1;
        }
        int min=Integer.MAX_VALUE;
        int minpos=0;
        for(int i=0;i<n;i++)
            if(s[i]<min){
                min=s[i];
                minpos=i;
            }
        int max=Integer.MIN_VALUE;
        int maxpos=0;
        for(int i=0;i<n;i++)
            if(s[i]>max){
                    max=s[i];
                    maxpos=i;
                }
        int sum=0;
        
        for(int i=0;i<n;i++)
            if(i==minpos||i==maxpos)
                continue;
            else
                sum+=Integer.max(getDistance(d, array[i], array[maxpos]), getDistance(d, array[i], array[minpos]));
        sum+=getDistance(d, array[minpos], array[maxpos]);
        System.out.println(sum);
        }
        catch(Exception e){
            System.out.println(2);
        }
    } 
} 