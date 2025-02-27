import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class BoardMoves {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            BigInteger b=new BigInteger("0");
            long current=8;
            for(long i=1;i<=n/2;i++){
                b=b.add(new BigInteger(Long.toString(current*i)));
                current+=8;
            }
            System.out.println(b.toString());
        }
    } 
}
