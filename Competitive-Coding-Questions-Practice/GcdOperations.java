import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
class GcdOperations {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            boolean possible=true;
            for(int i=0;i<n;i++){
                int num=array[i];
                if((i+1)%num!=0){
                    // System.out.println(i);
                    possible=false;
                    break;
                }
            }
            if(possible)
                System.out.println("YES");
            else
                System.out.println("NO");
        } 
    }    
}
