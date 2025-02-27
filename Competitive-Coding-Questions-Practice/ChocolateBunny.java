import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChocolateBunny {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int ptr1 = 0, ptr2 = 1;
        int[]array = new int[n];
        Arrays.fill(array, -1);
        while(ptr1 < n && ptr2 < n){
            if(ptr1 == ptr2){
                ptr2++;
                continue;
            }
            if(array[ptr1] != -1){
                ptr1++;
                continue;
            }
            if(array[ptr2] != -1){
                ptr2++;
                continue;
            }
            System.out.println("? " + (ptr1 + 1) + " " + (ptr2 + 1));
            System.out.flush();
            int r1 = Integer.parseInt(r.readLine());
            System.out.println("? " + (ptr2 + 1) + " " + (ptr1 + 1));
            System.out.flush();
            int r2 = Integer.parseInt(r.readLine());
            if(r1 > r2){
                array[ptr1] = r1;
                ptr1++;
            } else {
                array[ptr2] = r2;
                ptr2++;
            }

        }
        for(int i = 0; i < n; i++)
            if(array[i] == -1)
                array[i] = n;
        StringBuilder b = new StringBuilder("! ");
        for(int i : array){
            b.append(i);
            b.append(" ");
        }
        System.out.println(b);

    }
        
}
