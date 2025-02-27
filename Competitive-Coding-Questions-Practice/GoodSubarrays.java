import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoodSubarrays {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine();
            int [] array = new int [n + 1];
            int max = n;
            for(int i = 0; i < n; i++){
                array[i + 1] = array[i] + Integer.parseInt(Character.toString(s.charAt(i)));
                
            }
            for(int i = 0; i <= n; i++){
                array[i] -= i;
                max = Math.max(Math.abs(array[i]), max);
            }
            
            int[]arrayPos = new int[max + 1];
            int[]arrayNeg = new int[max + 1];

            Arrays.fill(arrayNeg, -1);
            Arrays.fill(arrayPos, -1);
            for(int i : array)
                if(i >= 0)
                    arrayPos[i]++;
                else  
                    arrayNeg[Math.abs(i)]++;
            long sum = 0;
            for(int i : arrayPos)
                if( i > 0)
                    sum += ((long)i * (long)(i + 1)) / 2;
            for(int i : arrayNeg)
                if( i > 0)
                    sum += ((long)i * (long)(i + 1)) / 2;
            System.out.println(sum);

            
                


        } 
    } 
}