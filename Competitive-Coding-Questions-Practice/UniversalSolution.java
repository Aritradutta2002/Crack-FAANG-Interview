import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniversalSolution {
    public static void main(String[]args)throws IOException{
        BufferedReader re=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(re.readLine());
        while(t-->0){
            String l=re.readLine();
            int r=0,p=0,s=0;
            for(int i=0;i<l.length();i++){
                char c=l.charAt(i);
                switch(c){
                    case 'R':
                        p++;
                        break;
                    case 'P':
                        s++;
                        break;
                    case 'S':
                        r++;
                        break;
                }
            }
            int max=Math.max(Math.max(r, p), Math.max(p, s));
            if(max==r&&max==p&&max==s)
                System.out.println(l);
            else{
                char c;
                if(max==p)
                    c='P';
                else if(max==r)
                    c='R';
                else
                    c='S';
                for(int i=0;i<l.length();i++){
                    System.out.print(c);
                }
                System.out.println();
            }       
        }

    }
    
}