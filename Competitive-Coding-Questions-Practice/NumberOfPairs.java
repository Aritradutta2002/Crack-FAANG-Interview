import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfPairs {
    static int gcd(int a, int b)  
{ 
    return b > 0 ? gcd(b, a % b) : a;  
} 
  
// Return the count of pairs 
// having GCD equal to g. 
        static int countGCD(int L, int R, int g) { 
            
            // Setting the value of L, R. 
            L = (L + g - 1) / g; 
            R = R / g; 
        
            // For each possible pair check if GCD is 1. 
            int ans = 0; 
            for (int i = L; i <= R; i++) 
            for (int j = L; j <= R; j++) 
                if (gcd(i, j) == 1) 
                ans++; 
        
            return ans; 
        } 
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int c = Integer.parseInt(t.nextToken());
            int d = Integer.parseInt(t.nextToken());
            int x = Integer.parseInt(t.nextToken());
            int a = 0;
            if(c - d > 0){
                if(x % (c - d) == 0){
                    a = countGCD(0, x / (c - d) + 10, x / (c - d));
                }          
            }
            System.out.println(a);
        }    
    }
        
}
