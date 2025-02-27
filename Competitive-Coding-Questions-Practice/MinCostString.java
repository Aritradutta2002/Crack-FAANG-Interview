import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinCostString {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken()), k = Integer.parseInt(t.nextToken());
        int[]arr = new int[k];
        StringBuilder b = new StringBuilder();
        int curr = 0;
        b.append('a');
        int c = 0;
        while(true){
            if(k == 1 || k == 2)
                break;
            if(c > n + 10)
                break;
            c++;
            int last = curr;
            curr = arr[curr];
            // System.out.println(curr + 
            // " " + arr[curr] + " " +arr[arr[curr]]);
            if(arr[arr[curr]] == k - 1)
                if(arr[curr] == k - 1)
                    break;
                else
                    arr[curr]++;

            b.append((char)(curr + 'a'));
            arr[last]++;
            // System.out.println(b);
        }
        b.append((char)('a' + (k - 1)));
        b.append((char)('a' + (k - 1)));
        String s = b.toString();

        if(k == 1)
            s = "a";
        else if(k == 2)
            s = "aabb";
        int N = s.length();
        StringBuilder ans = new StringBuilder();
        for(int i= 0 ; i < n ; i++){
            ans.append(s.charAt(i % N));
        }
        System.out.println(ans);
    }
        
}
