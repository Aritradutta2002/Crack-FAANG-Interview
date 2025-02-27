import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BigVova {
    public static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    }
    static class Compare implements Comparator<Integer>{
        int max;
        Compare(int max){
            this.max=max;
        }
        @Override
        public int compare(Integer a, Integer b) {
            int gcd1=gcd(a, max);
            int gcd2=gcd(b,max);
            return Integer.compare(gcd2, gcd1);
        }

    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            ArrayList <Integer>list=new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(Integer.parseInt(data[i]));
            int current=0;
            for(int i:list)
                current=Math.max(current, i);
            ArrayList<Integer>ordered=new ArrayList<>();
            for(int i=0;i<n;i++){
                int pos=0;
                int max=0;
                for(int j=0;j<n-i;j++){
                    int gcd=gcd(list.get(j), current);
                    if(gcd>max){
                        pos=j;
                        max=gcd;
                    }
                }
                current=max;
                ordered.add(list.get(pos));
                list.remove(pos);
            }
            for(int i:ordered)
                System.out.print(i+" ");
            System.out.println();
        }   
    } 
}
