import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SubsetSum {
    static String get(int[]data){
        int last=data[data.length-1];
        for(int i:data){
            if(last-i==i)
                return "YES";
        }
        return "NO";
    }
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            r.readLine();
            String[]s=r.readLine().split(" ");
            int []data=new int[s.length];
            for(int i=0;i<s.length;i++){
                data[i]=Integer.parseInt(s[i]);
            }
            for(int i=1;i<data.length;i++){
                data[i]=data[i-1]+data[i];
            }
            System.out.println(get(data));
            
        }

    }
}