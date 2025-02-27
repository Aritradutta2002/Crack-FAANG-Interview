import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PermutationByMerger {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            boolean []check=new boolean[n];
            Arrays.fill(check, true);
            int[]seq=new int[n];
            String[]data=r.readLine().split(" ");
            int ptr=0;
            for(String s:data){
                int num=Integer.parseInt(s);
                if(check[num-1]){
                    check[num-1]=false;
                    seq[ptr]=num;
                    ptr++;
                }
            }
            for(int i:seq){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    
}