import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class FerisWheel {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int x = Integer.parseInt(t.nextToken());

        t = new StringTokenizer(r.readLine());
        ArrayList<Long>array = new ArrayList<>();
        for(int i = 0; i < n; i++)
            array.add(Long.parseLong(t.nextToken()));
        Collections.sort(array);

        int ptr1 = 0, ptr2 = n-1,count = 0;
        while(ptr1<ptr2){
            count++;
            if(array.get(ptr1)+array.get(ptr2) <= x){
                ptr1++;
                ptr2--;
            } else 
                ptr2--;
        }
        if(ptr1 == ptr2)
            count++;

        System.out.println(count);
    } 
}