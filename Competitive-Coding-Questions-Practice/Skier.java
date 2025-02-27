import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Skier {
    static boolean isOpposite(char a,char b){
        return a=='S'&&b=='N'||a=='N'&&b=='S'||a=='E'&&b=='W'||a=='W'&&b=='E';
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine();
            int n=s.length();
            int count=0;
            Queue <Character>q=new LinkedList<>();
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                if(q.isEmpty())
                    q.add(c);
                else{
                    if(isOpposite(c, q.peek())){
                        q.remove();
                        count++;
                    }
                    else{
                        q.add(c);
                        count+=5;
                    }
                }
            }
            System.out.println(count);
        } 
    } 
}