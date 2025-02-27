import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BinaryPalindromes {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            int n=Integer.parseInt(r.readLine());
            int[]array=new int[n];
            int zeros=0,ones=0;
            for(int i=0;i<n;i++){
                String s=r.readLine();
                array[i]=s.length()-s.length()%2;
                for(char c:s.toCharArray())
                    if(c=='0')
                        zeros++;
                    else
                        ones++;
            }
            Arrays.sort(array);
            int count=0;
            for(int i:array){
                zeros-=zeros%2;
                ones-=ones%2;
                if(i<=zeros+ones){
                    count++;
                    int num=i;
                    int diff=Math.min(zeros, i);
                    zeros-=diff;
                    num-=diff;
                    diff=Math.min(ones,num);
                    ones-=diff;
                }
            }
            System.out.println(count);

        } 
    } 
}
