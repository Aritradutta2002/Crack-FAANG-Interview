import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MotaracksBirthday {
    public static int getValue(int[]array, int replacement, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            int num1 = array[i];
            int num2 = array[i+1];
            if(num1 == -1)
                num1 = replacement;
            if(num2 == -1)
                num2 = replacement;
            max = Math.max(max, Math.abs(num1 - num2));
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-->0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int  i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            
            int max = 0;
            int min = 1000000000;
            for(int i = 0; i < n; i++){
                if(array[i]!=-1){
                    boolean c1 = false,c2 = false;
                    if(i - 1 >= 0)
                        if(array[i - 1] == -1)
                            c1 = true;
                    if(i + 1 < n)
                        if(array[i + 1] == -1)
                            c2 = true;
                    if(c1 || c2){
                        max = Math.max(array[i], max);
                        min = Math.min(array[i], min);
                    }
                }
            }

            int num1 = min + (max - min) / 2;
            int num2 = min + (max - min) / 2 + (max - min) % 2;

            int ans1 = getValue(array, num1, n);
            int ans2 = getValue(array, num2, n);
            if(ans1 < ans2)
                System.out.println(ans1 + " " + num1);
            else
                System.out.println(ans2 + " " + num2);

        }
    }
        
}
