import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MazeGame {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String []data=r.readLine().split(" ");
        int n=Integer.parseInt(data[0]);
        int q=Integer.parseInt(data[1]);
        boolean [][]pos=new boolean[2][n];
        int count=0;
        while(q-->0){
            String[]query=r.readLine().split(" ");
            int x=Integer.parseInt(query[0]);
            int y=Integer.parseInt(query[1]);
            int other;
            if(x==2)
                other=1;
            else
                other=2;
            x--;
            y--;
            other--;
            if(pos[x][y]){
                if(pos[other][y])
                    count--;
                if(y!=0)
                    if(pos[other][y-1])
                        count--;
                if(y!=n-1)
                    if(pos[other][y+1])
                        count--;

            }
            if(!pos[x][y]){
                if(pos[other][y])
                    count++;
                if(y!=0)
                    if(pos[other][y-1])
                        count++;
                if(y!=n-1)
                    if(pos[other][y+1])
                        count++;

            }
            pos[x][y]=!pos[x][y];
            if(count==0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }    
    } 
}