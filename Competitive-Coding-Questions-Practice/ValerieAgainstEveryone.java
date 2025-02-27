import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValerieAgainstEveryone {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n ; i++)
                array[i] = Integer.parseInt(t.nextToken());
            boolean found = false;
            for(int i = 0; i < n;i++){
                int num = array[i];
                int count = 0;
                for(int j = 0;j < i; j++)
                    if(array[j] == num - 1)
                        count++;
                    else if(array[j]==num)
                        found = true;
                if(count >= 2)
                    found = true;
                count = 0;
                for(int j = i + 1;j < n; j++)
                    if(array[j] == num - 1)
                        count++;
                    else if(array[j]==num)
                        found = true;
                if(count >= 2)
                    found = true;

            }
            if(found)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
        
}
