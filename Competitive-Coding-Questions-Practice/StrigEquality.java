import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StrigEquality {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-->0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            String s1 = r.readLine();
            char[]a = new char[n];
            String s2 = r.readLine();
            char[]b = new char[n];
            for(int i = 0; i < n ;i++){
                a[i] = s1.charAt(i);
                b[i] = s2.charAt(i);
            }
            Arrays.sort(a);
            Arrays.sort(b);
            boolean less = false;
            int [][]more = new int[26][26];
            for(int i = 0; i< n; i++)
                if(b[i] >a [i] )
                    more [a[i] - 'a'][Math.abs(a[i]-b[i])%26]++;
                else if(b[i]<a[i])
                    less = true;
            boolean check = true;
            // for(int[]i:more){
            //     for(int j:i)
            //         System.out.print(j+" ");
            //     System.out.println();
            // }

            for(int i = 0;i <25; i++){
                int sum = 0;
                for(int j = 1; j< 26; j++){
                    sum += more[i][j];
                }
                // System.out.println(sum);
                if(sum%k !=0){
                    check = false;
                    break;
                }
                if(i!=25)
                    for(int j = 1; j < 26;j++)
                        more[i+1][j-1] += more[i][j];
            }
            int sum = 0;
            for(int j = 1; j < 26;j++)
                    sum+=more[25][j];
            if(sum%k!=0)
                check = false; 
            if(less)
                System.out.println("NO");
            else if(!check)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
        
}
