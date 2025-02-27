import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Game {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine().trim();
            int n=s.length();
            Queue<Character>queue=new LinkedList<>();
            int count=0;
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                if(queue.isEmpty())
                    queue.add(c);
                else
                    if(queue.peek()!=c){
                        count++;
                        queue.remove();
                    }
                    else
                        queue.add(c);
            }
            if(count%2==1)
                System.out.println("DA");
            else
                System.out.println("NET");
        } 
    } 
}