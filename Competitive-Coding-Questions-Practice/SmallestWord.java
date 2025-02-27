import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SmallestWord {
    static char invert(char c){
        if(c=='a')
            return 'b';
        return 'a';
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String s=r.readLine().trim();
        int n=s.length();
        int[]array=new int[n];
        char last=s.charAt(0);
        for(int i=1;i<n;i++){
            if(s.charAt(i)!=last){
                array[i-1]++;
                last=s.charAt(i);
            }
        }
        if(last=='a')
            array[n-1]++;
        for(int i:array)
            System.out.print(i+" ");
        System.out.println();
    } 
}
