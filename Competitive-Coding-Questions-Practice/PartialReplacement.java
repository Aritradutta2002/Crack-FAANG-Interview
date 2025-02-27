import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialReplacement {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            String s = r.readLine().trim();
            char []array = new char[n];
            for(int i = 0; i <n; i ++)
                array[i] = s.charAt(i);
            int lastX = 0;
            int count = 0;
            for(int i = 0; i < n ;i ++)
                if(array[i] == '*'){
                    array[i] = 'x';
                    lastX = i;
                    count++;
                    break;
                }
            int end = 0;
            for(int i = n - 1; i >= 0 ;i --)
                if(array[i] == '*'){
                    array[i] = 'x';
                    end = i;
                    count++;
                    break;
                    
                }
            int ptr = lastX;
            while(ptr < end){
                int pos = 0;
                for(int i = ptr + 1; i <= Math.min(ptr + k, end); i  ++)
                    if(array[i] != '.')
                        pos = i;
                    if(array[pos] == 'x')
                        break;
                    else{
                        ptr = pos;
                        count ++;
                    }

            }

            System.out.println(count);

            
        }
    }
        
}
