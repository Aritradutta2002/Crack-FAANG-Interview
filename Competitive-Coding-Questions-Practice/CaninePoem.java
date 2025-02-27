import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaninePoem {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            String s = r.readLine().trim();
            int n = s.length();
            boolean []visited = new boolean[n];
            int count = 0;
            for(int i = 0; i < n; i++){
                if(visited[i])
                    continue;
                for(int j = i + 1; j < i + 3 && j < n; j++){
                    if(visited[j])
                        continue;
                    if(s.charAt(i) == s.charAt(j)){
                        count ++;
                        visited[j] = true;
                    }
                }
            }
            System.out.println(count);

        }
    }
        
}
