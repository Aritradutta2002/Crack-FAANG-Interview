import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberIntoSequence {
    static ArrayList<Paiir> getFactors(long n){
        ArrayList<Paiir> list = new ArrayList<>();
        for (long i = 2; i <= Math.ceil(Math.sqrt(n)); i+= 1) 
        { 
            // While i divides n, print i and divide n 
            if(n % i ==0){
                int count = 0;
                while (n%i == 0) 
                { 
                    count ++;
                    n /= i; 
                }
                list.add(new Paiir(i, count));
            } 
        } 
  
        // This condition is to handle the case whien 
        // n is a prime number greater than 2 
        if (n > 2) 
            list.add(new Paiir(n, 1));
        return list;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            long n = Long.parseLong(r.readLine());
            ArrayList <Paiir>factors = getFactors(n);
            int maxCount = 0;
            for(Paiir i : factors)
                maxCount = Math.max(i.count, maxCount);
            long[]array = new long[maxCount];
            Arrays.fill(array, 1);
            for(Paiir i : factors){
                for(int j = maxCount - 1;j >= maxCount - i.count; j--)
                    array[j] *= i.factor;
            }
            StringBuilder b = new StringBuilder();
            for(long i : array){
                b.append(i);
                b.append(" ");
            }
            System.out.println(maxCount);
            System.out.println(b);

        }
    }
        
}
class Paiir{
    long factor;
    int count;
    Paiir(long factor, int count){
        this.factor = factor;
        this.count = count;
    }
}
