import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class WalkingRobot {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String s=r.readLine();
            boolean found=false;
            for(int i=0;i<n-1;i++){
                char a=s.charAt(i);
                char b=s.charAt(i+1);
                boolean bool=a=='R'&&b=='L'||a=='L'&&b=='R'||a=='U'&&b=='D'||a=='D'&&b=='U';
                if(bool){
                    System.out.println((i+1)+" "+(i+2));
                    found=true;
                    break;
                }
            }
            if(found)
                continue;
            for(int i=0;i<n-3;i++){
                char a=s.charAt(i);
                char b=s.charAt(i+1);
                char c=s.charAt(i+2);
                char d=s.charAt(i+3);
                boolean bool=a!=b&&a!=c&&a!=d&&b!=c&&b!=d&&c!=d;
                if(bool){
                    System.out.println((i+1)+" "+(i+4));
                    found=true;
                    break;
                }
            }
            if(found)
                continue;
            System.out.println(-1);
        } 
    } 
}