import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UniqueBidAuction {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            int[]array = new int[n];
            StringTokenizer t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n; i ++){
                array[i] = Integer.parseInt(t.nextToken());
            }
            int max = 0;
            for(int i :array)
                max = Math.max(i, max);
            int[]freq = new int[max + 1];
            for(int i : array)
                freq[i] ++;
            int found = -1;
            for(int i = 0; i < max + 1; i++)
                if(freq[i] == 1){
                    found = i;
                    break;
                }
            if(found == -1)
                System.out.println(found);
            else{
                for(int i = 0; i < n; i++)
                    if(array[i] == found){
                        System.out.println(i + 1);
                        break;
                    }
            }
            
        }
    }
        
}
