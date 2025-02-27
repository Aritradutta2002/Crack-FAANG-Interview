import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Steps {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            long n=Long.parseLong(data[0]);
            long k=Long.parseLong(data[1]);
            StringBuilder s=new StringBuilder();
            while(n-->0){
                long num=Integer.parseInt(r.readLine());
                if(num==0)
                    s.append('1');
                else if(k>num)
                    s.append('0');
                else if(k==0)
                    s.append('0');
                else{
                    if(num%k==0)
                        s.append('1');
                    else
                        s.append("0");
                }
            }
            System.out.println(s.toString());
        }
    }
}