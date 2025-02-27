import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class HiringWorkers2 {
    static ArrayList<Integer> get (int x){
        ArrayList<Integer> list = new ArrayList<>();
        int val  = (int)Math.ceil(Math.sqrt(x));
        for( int i = 2; i <=val ; i++){
            if(x % i ==0 ){
                int ans = 1;
                while(x % i == 0){
                    x /= i;
                    ans *= i;
                }
                list.add(ans);
            }
        }
        if(x != 1)
            list.add(x);
        return list;

        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 --> 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            
            int k = Integer.parseInt(t.nextToken());
            int x = Integer.parseInt(t.nextToken());

            int[]array = new int[k];
            Arrays.fill(array, 1);
            ArrayList<Integer> list = get(x);
            list.clear();
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(2);
            list.add(2);
            list.add(3);
            list.add(3);
            list.add(4);
            Collections.sort(list);
            int current = 0;
            int size = list.size();
            while(true){
                boolean found = false;
                for(int i = 0; i <k; i++)
                    if(current + i >= size){
                        found = true;
                        break;
                    }
                    else
                        array[i] *= list.get(current + i);
                current += k * 2;
                if(found)
                    break;
            }
            current = k;
        
            while(true){
                boolean found = false;
                for(int i = current; i < Math.min(size, current + k); i++)
                    if(current + i >= size){
                        found = true;
                        break;
                    }
                    else
                        
                current += k * 2;
                if(found)
                    break;
            }
            long sum = 0;
            for(int i : array){
                System.out.print(i+" ");
                sum += i;
            }
            System.out.println();
            System.out.println(sum);


        }
    }
        
}
