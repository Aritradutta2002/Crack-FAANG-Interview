import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class StringModification {
    static String rotate(String s,int k){
        k--;
        String newS=s.substring(k,s.length());
        for(int i=k-1;i>=0;i--)
            newS+=Character.toString(s.charAt(i));
        return newS;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String s=r.readLine();
            int k=1;
            String min=s;
            for(int i=2;i<=n;i++){
                String newS=rotate(s, i).trim();
                if(min.compareTo(newS)>0){
                    min=newS;
                    k=i;
                }
            }
            System.out.println(min);
            System.out.println(k);
        } 
    } 
}