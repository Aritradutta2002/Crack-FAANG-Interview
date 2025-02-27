import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class GcdCompression {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n*2];
            for(int i=0;i<2*n;i++)
                array[i]=Integer.parseInt(data[i]);
            ArrayList<Integer>even=new ArrayList<>();
            ArrayList<Integer>odd=new ArrayList<>();
            for(int i=0;i<2*n;i++)
                if(array[i]%2==0)
                    even.add(i+1);
                else
                    odd.add(i+1);
            
            int es=even.size();
            int os=odd.size();
            if(es%2!=0){
                even.remove(es-1);
                odd.remove(os-1);
            }
            else
                if(es>=2){
                    even.remove(es-1);
                    even.remove(es-2);
                }
                else{
                    odd.remove(os-1);
                    odd.remove(os-2);
                }
            es=even.size();
            os=odd.size();
            for(int i=0;i<es;i+=2)
                System.out.println(even.get(i)+" "+even.get(i+1));
            for(int i=0;i<os;i+=2)
                System.out.println(odd.get(i)+" "+odd.get(i+1));
            
        } 
    } 
}