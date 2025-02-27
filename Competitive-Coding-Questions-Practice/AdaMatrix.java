import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class AdaMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split(" ");
            for(int i=1;i<n;i++)
                r.readLine();
            int[]array=new int[n-1];
            for(int i=0;i<n-1;i++)
                array[i]=Integer.parseInt(data[i+1]);
            boolean []b=new boolean [n-1];
            int c=2;
            for(int i=0;i<n-1;i++){
                b[i]=array[i]==c;
                c++;
            }
            boolean current=true;
            int count=0;
            for(int i=n-2;i>=0;i--){
                if(b[i]!=current){
                    count++;
                    current=!current;
                }
            }
            System.out.println(count);

        }
    } 
}
