import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class DiffrentDivisors {
    static boolean check (int n, int d){
        int last = 1;
        int c = 3;
        ArrayList <Integer>factors1 = new ArrayList<>();
        ArrayList <Integer>factors2 = new ArrayList<>();

        for(int i = 2; i <= Math.sqrt(n) + 2; i++){
            if(n % i == 0){
                factors1.add(i);
                factors2.add(n / i);
            }
        }
        for(int i : factors1)
            if( i > last && i - last >= d){
                last = i;
                c --;
            }

        Collections.reverse(factors2);
        for(int i : factors2)
            if( i > last && i - last >= d){
                last = i;
                c --;
            }

        return c <= 0;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int d = Integer.parseInt(r.readLine());
            long n1 = 1 + d;
            long n2 = n1 + d;

            System.out.println(Math.min(n1 * n2, n1 * n1 * n1));
        }
    }

}
