import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Knapsack {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 --> 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            long sum = Long.parseLong(t.nextToken());
            mPair[]array = new mPair[n];
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n; i++)
                array[i] = new mPair(i , Integer.parseInt(t.nextToken()));
            
            Arrays.sort(array, new Comparator<mPair>(){
 
                @Override
                public int compare(mPair o1, mPair o2) {
                    return Long.compare(o1.value, o2.value);
                }
                
            }); 
            ArrayList <Integer>list = new ArrayList<>();   
            long total = 0;
            for(mPair p: array){
                total += p.value;
                if(total > sum){
                    total -= p.value;
                    continue;
                }
                
                list.add(p.pos);
                if(total >= sum / 2 +sum % 2)
                    break;
            }
            if(total <= sum && total>=sum/2+sum%2){
                System.out.println(list.size());
                for(int i : list)
                    System.out.print((i+1)+" ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
 
            
        }
    }
        
}
class mPair{
    int pos;
    long value;
    mPair(int pos, long value){
        this.pos = pos;
        this.value = value;
    }
}