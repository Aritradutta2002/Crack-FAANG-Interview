import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

 class FairElections {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n1 = Integer.parseInt(t.nextToken()), n2 = Integer.parseInt(t.nextToken());
            int[]array1 = new int[n1], array2 = new int[n2];
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n1; i ++)
                array1[i] = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n2; i++)
                array2[i] = Integer.parseInt(t.nextToken());

            Arrays.sort(array1);
            Arrays.sort(array2);

            long sum1 = 0, sum2 = 0;
            for(int i : array1)
                sum1 += i;
            for(int i : array2)
                sum2 += i;

            long diff = sum2 - sum1;
            int count = 0;

            int ptr1 = 0, ptr2 = n2 - 1;
            while(ptr1 < n1 && ptr2 >= 0 && diff >= 0){
                if(array1[ptr1] < array2[ptr2]){
                    count++;
                    diff -= (array2[ptr2] - array1[ptr1]) * 2;
                    ptr1++;
                    ptr2--;
                }
                else
                    break;

                // System.out.println(diff + " " + ptr1 + " " + ptr2);
            }
            if( diff < 0)
                System.out.println(count);
            else
                System.out.println(-1);
        }
    }
        
}
