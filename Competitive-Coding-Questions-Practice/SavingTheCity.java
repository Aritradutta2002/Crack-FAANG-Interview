import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SavingTheCity {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            StringTokenizer t=new StringTokenizer(r.readLine());
            int a=Integer.parseInt(t.nextToken());
            int b=Integer.parseInt(t.nextToken());
            String s=r.readLine();
            long count=0;
            int n=s.length();
            int last=-1;
            boolean counting=false;
            for(int i=0;i<n;i++){
                // System.out.println(last+" "+counting+" "+count);
                if(s.charAt(i)=='1'){
                    if(!counting){    
                        if(last==-1)
                            count+=a;
                        else{
                            // System.out.println((i-last-1));
                            // System.out.println(last);
                            if((i-last-1)*b<a)
                                count+=(i-last-1)*b;
                            else
                                count+=a;
                        }
                    }
                    last=i;
                    counting=true;
                }
                else
                    counting=false;
                
            }
            System.out.println(count);
        } 
    } 
}
