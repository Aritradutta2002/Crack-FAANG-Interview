import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class RarityAndNewDress {
    static boolean check(int n,int i){
        return i>=0&&i<n;
    }
    static int getCount(char[][]array,int m,int n,int x,int y,int k){
        int[]pos=new int[((k-1)*4+4)*2+1];
        int ptr=0;
        
        for(int i=0;i<pos.length;i+=2)
            if(!check(m, pos[i]))
                return 0;
        for(int i=1;i<pos.length;i+=2)
            if(!check(n, pos[i]))
                return 0;
        char current=array[x][y];
        for(int i=0;i<pos.length;i+=2)
            if(array[pos[i]][pos[i+1]]!=current)
                return 0;
        return 1+getCount(array, m, n, x, y, k+1);
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String []s=r.readLine().split(" ");
        int m=Integer.parseInt(s[0]);
        int n=Integer.parseInt(s[1]);
        char[][]array=new char[m][n];
        for(int i=0;i<m;i++){
            String ss=r.readLine();
            for(int j=0;j<n;j++)
                array[i][j]=ss.charAt(j);
        }
        int total=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                total+=getCount(array, m, n, i, j, 0)+1;
        System.out.println(total);
    } 
}