import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class DecreaseSumOfDigits {
    static int getSum(String s){
        int sum=0;
        for(char c:s.toCharArray())
            sum+=Integer.parseInt(Character.toString(c));
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            String s=t1.nextToken().trim();
            int sum=Integer.parseInt(t1.nextToken());
            int n=s.length();
            if(getSum(s)<=sum){
                System.out.println(0);
                continue;
            }
            boolean [] array=new boolean [n];
            for(int i=1;i<n;i++)
                array[i]=getSum(Long.toString(Long.parseLong(s.substring(0, i))+1))<=sum;
            int maxPos=0;
            for(int i=0;i<n;i++)
                if(array[i])
                    maxPos=i;
            long mul=(long)Math.pow(10,(n-maxPos));
            long n2=Long.parseLong(s.substring(maxPos,n));
            System.out.println((mul-n2));
            
        } 
    } 
}
