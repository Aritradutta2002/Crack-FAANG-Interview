import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class RobotDetector {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String[]data=r.readLine().split(" ");
        int x=Integer.parseInt(data[0]);
        int y=Integer.parseInt(data[1]);
        StringBuilder b=new StringBuilder();
        b.append("U");
        for(int i=0;i<20;i++)
            b.append("R");
        System.out.println(b);
    } 
}
