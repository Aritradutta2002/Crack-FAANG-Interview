import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class BowlingStrategy {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int overs=Integer.parseInt(data[0]);
            int players=Integer.parseInt(data[1]);
            int max=Integer.parseInt(data[2]);
            if(overs>max*players||(players==1&&overs>1))
                System.out.println(-1);
            else{
                StringBuilder b=new StringBuilder();
                int current=1;
                for(int i=0;i<overs;i++){
                    b.append(Integer.toString(current));
                    current++;
                    if(current>players)
                        current=1;
                    b.append(" ");
                }
                System.out.println(b.toString());
            }

        }
    } 
}
