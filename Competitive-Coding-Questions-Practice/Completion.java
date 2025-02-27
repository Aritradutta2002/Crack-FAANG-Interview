import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://codeforces.com/contest/1372/problem/A
*/

public class Completion {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            while(n-->0){
                System.out.print(1+" ");
            }
            System.out.println();
        }
    }
    
}