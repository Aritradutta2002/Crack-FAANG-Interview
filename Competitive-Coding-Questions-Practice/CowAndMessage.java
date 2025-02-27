import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CowAndMessage {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int n = s.length();
        int[][]array = new int[n + 1][26];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 26; j++ )
                array[i][j] = array[i + 1][j];
            array[i][s.charAt(i) % 26]++; 
        }

        long max = 0;
        for(int i = 0; i < 26; i++)
            for(int j = 0; j < 26; j++){
                long ans = 0;
                for(int l = 0; l < n; l++)
                    if(s.charAt(l) % 26== i)
                        ans += array[l + 1][j];
                max = Math.max(ans, max);
        }
    
        for(int i = 0; i < 26; i++)
            max = Math.max(max, array[0][i]);
        System.out.println(max);
    }
    
        
}
