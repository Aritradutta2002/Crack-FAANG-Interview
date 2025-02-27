import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Circle {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        r.readLine();
        String []data=r.readLine().split(" ");
        int[]array=new int[data.length];
        for(int i=0;i<data.length;i++)
            array[i]=Integer.parseInt(data[i]);
        if(array.length==1)
            System.out.println(array[0]);
        else{
            long even=0;
            long odd=0;
            Sum[]sums=new Sum[array.length];
            for(int i=0;i<array.length;i++){
                sums[i]=new Sum(even,odd);
                if(i%2==0)
                    even+=array[i];
                else
                    odd+=array[i];
            }
            long max=Long.MIN_VALUE;
            for(int i=0;i<sums.length;i++){
                long sum;
                if(i%2==0)
                    sum=even-sums[i].even+sums[i].odd;
                else
                    sum=odd-sums[i].odd+sums[i].even;
                // sum+=array[i];
                if(sum>max)
                    max=sum;
                
            }
            // if(array[0]+array[1]+array[2]>max&&array.length!=3){
            //     max=array[0]+array[1]+array[2];
            // }
            // if(array[array.length-1]+array[array.length-2]+array[array.length-3]>max&&array.length!=3){
            //     max=array[array.length-1]+array[array.length-2]+array[array.length-3];
            // }
            System.out.println(max);
            
        }
        
        
    }   
}
class Sum{
    long even;
    long odd;
    Sum(long even,long odd){
        this.even=even;
        this.odd=odd;
    }
}