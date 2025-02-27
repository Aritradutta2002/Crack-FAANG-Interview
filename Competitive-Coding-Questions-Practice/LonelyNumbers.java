import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class LonelyNumbers {
    static ArrayList<Integer> sieveOfEratosthenes(int n) 
    { 
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
        ArrayList<Integer>list = new ArrayList<>();     
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) 
                list.add(i); 
        } 
        return list;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1 =Integer.parseInt(r.readLine());
        StringTokenizer t=new StringTokenizer(r.readLine());
        ArrayList<Integer> list = sieveOfEratosthenes(1000000);
        while(t1-->0){
            int n = Integer.parseInt(t.nextToken());
            int ans = 0;
            int count = 0;
            for(int num : list){
                if(num > n)
                    break;
                if(Math.pow(num, 2) > n)
                    count++;
            }
            System.out.println(count);

        }
    } 
}
