import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://codeforces.com/contest/1372/problem/C
 */

public class Baseball {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            r.readLine();
            String[]s=r.readLine().split(" ");
            int[]array=new int[s.length];
            for(int i=0;i<s.length;i++){
                array[i]=Integer.parseInt(s[i]);
            }
            boolean last=false;
            long count=0;
            for(int i=0;i<array.length;i++){
                if(array[i]!=i+1){
                    if(!last){
                        count++;
                        if(count==2)
                            break;
                        last=true;
                    }
                }
                else
                    last=false;
            }
            System.out.println(count);
        }
    }
}