import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class CodeForcesSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(r.readLine());
        long[]array=new long[10];
        Arrays.fill(array, 1);
        int ptr=0;
        long product=1;
        while(product<n){
            product/=array[ptr];
            array[ptr]++;
            product*=array[ptr];
            ptr=(ptr+1)%10;
        }
        char[]s="codeforces".toCharArray();
        StringBuilder b=new StringBuilder();
        for(int i=0;i<10;i++){
            for(int j=0;j<array[i];j++){
                b.append(s[i]);
            }
        }
        System.out.println(b);
    } 
}
