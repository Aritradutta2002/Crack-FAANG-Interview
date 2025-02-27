import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RestoreModulo {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            int[]array = new int[n];
            int n1 = -1, n2 = -1;
            boolean c = true;
            StringTokenizer t = new StringTokenizer(r.readLine());
            int max = 0;
            for(int i = 0 ; i< n; i ++){
                array[i] = Integer.parseInt(t.nextToken());
                max = Math.max(max, array[i]);
            }
            for(int i = 1; i < n; i ++){
                if(array[i] > array[i - 1]){
                    if(n1 == -1)
                        n1 = array[i] - array[i - 1];
                    else
                        if(n1 != array[i] - array[i - 1])
                            c = false;
                } else{
                    if(n2 == -1)
                        n2 = array[i - 1] - array[i];
                    else
                        if(n2 != array[i - 1] - array[i])
                            c = false;
                }
            }
            if(!c) 
                System.out.println(-1);
            else if(n1 == 0 && n2 != -1)
                System.out.println(-1);
            else if(n1 == -1 || n2 == -1)
                System.out.println(0);
            else if((n1 + n2) <= max)
                System.out.println(-1);
            else
                System.out.println((n1 + n2) + " " + n1);

            
        }
    }
        
}
