import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Apartments{
    
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        int k = Integer.parseInt(t.nextToken());
        
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            array1.add( Integer.parseInt(t.nextToken()) );
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < m; i++)
            array2.add( Integer.parseInt(t.nextToken()));
        
        Collections.sort(array1);
        Collections.sort(array2);

        int ptr1 = 0, ptr2 = 0, count = 0;
        while(ptr1 < n && ptr2 < m)
            if(Math.abs(array1.get(ptr1) - array2.get(ptr2)) <= k){
                ptr1++;
                ptr2++;
                count++;
            }
            else
                if(array1.get(ptr1) < array2.get(ptr2))
                    ptr1++;
                else
                    ptr2++;

        System.out.println(count);

    }
}
