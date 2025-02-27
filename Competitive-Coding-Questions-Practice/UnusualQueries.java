import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 class UnusualQueries {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int q = Integer.parseInt(t.nextToken());
        int s = Integer.parseInt(t.nextToken());
        
        int[]array = new int[n];
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        int ans = 0;
        int [][]memory = new int[n][n];
        
        for(int i = 0; i < n; i++){
            int count = 0;
            int last = 0;
            for(int j = i; j < n; j++){
                if(array[j] > last){
                    last = array[j];
                    count++;
                }
                memory[i][j] = count;
            }
        }
        // for(int [] i :memory){
        //     for(int j:i)
        //         System.out.print(j+" ");
        //     System.out.println();
        // }
        while(q-->0){
            t = new StringTokenizer(r.readLine());
            int left = (Integer.parseInt(t.nextToken()) + ans * s - 1) % n;
            int right = (Integer.parseInt(t.nextToken()) + ans * s - 1) % n;
            if(left > right){
                int temp = left;
                left = right;
                right = temp;
            }
            // System.out.println(left+" "+right);
            ans = 0;
            for(int i = left; i < right; i++ )
                ans = Math.max(ans, memory[i][right] - memory[i][i]);
            ans++;
            System.out.println(ans);

        }   
    } 
}
