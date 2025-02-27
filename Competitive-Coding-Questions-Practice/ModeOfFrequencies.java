import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class ModeOfFrequencies {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[10+1];
            for(String s:data)
                array[Integer.parseInt(s)-1]++;
            
            int[]freq=new int[n+1];
            for(int i:array)
                if(i-1>=0)    
                    freq[i]++;
            int pos=0;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n+1;i++)
                if(freq[i]>max){
                    pos=i;
                    max=freq[i];
                }
            System.out.println(pos);
        }
    }     
}