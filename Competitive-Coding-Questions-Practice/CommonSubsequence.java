import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CommonSubsequence {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            r.readLine();
            String[]data1=r.readLine().split(" ");
            String[]data2=r.readLine().split(" ");
            HashSet <Integer>s=new HashSet<>();
            boolean found=false;
            for(String l:data1){
                s.add(Integer.parseInt(l));
            }
            for(String l:data2){
                if(s.contains(Integer.parseInt(l))){
                    System.out.println("YES");
                    System.out.println(1+" "+l);
                    found=true;
                    break;
                }
            }
            if(!found)
                System.out.println("NO");
        }
    }
}