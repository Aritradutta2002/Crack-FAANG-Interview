import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CommonPrefix {
    static char getNext(char c){
        if(c=='y'){
            return 'b';
        }
        return (char)(c+1);
    }
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []s=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=Integer.parseInt(s[i]);
            }
            char c='b';
            for(int i=0;i<200;i++){
                if(i<array[0])
                    System.out.print('a');
                else
                    System.out.print(c);
            }
            c=getNext(c);
            System.out.println();
            for(int i=0;i<n-1;i++){
                // System.out.println("~~~~");
                for(int j=0;j<200;j++){
                    if(j<array[i+1])
                        System.out.print('a');
                    else
                        System.out.print(c);
                }
                System.out.println();
                c=getNext(c);
            }
            for(int i=0;i<200;i++)
                System.out.print('a');
            System.out.println();
        }
    }
    
}