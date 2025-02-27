import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BinaryTable {
    public static char invert(char c){
        if(c == '1')
            return '0';
        else
            return '1';
    }
    public static void get(int i, int j , char[]array,ArrayList<String>list){
        if(array[i]=='1'&&array[i + 1]=='1'){
            StringBuilder b = new StringBuilder();
            b.append(i);
            b.append(" ");
            b.append(j+1);
            b.append(" ");
            b.append(i);
            b.append(" ");
            b.append(j+2);
            b.append(" ");
            b.append(i+1);
            b.append(" ");
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-->0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            char[][]array = new char[n][m];
            for(int i = 0 ; i <  n ;i++){
                String s = r.readLine();
                for(int j = 0; j < m; j++)
                    array[i][j] = s.charAt(j);
            }
            ArrayList<String> answers = new ArrayList<>();
            for(int i = 0; i < n - 1; i++)
                for(int j = 0; j < m; j++)
                    if(array[i][j] == '1'){
                        StringBuilder b = new StringBuilder();
                        b.append(i+1);
                        b.append(" ");
                        b.append(j+1);
                        b.append(" ");
                        b.append(i+2);
                        b.append(" ");
                        b.append(j+1);
                        b.append(" ");
                        array[i + 1][j] = invert(array[i + 1][j]);
                        if(j == m - 1){
                            array[i + 1][j - 1] = invert(array[i + 1][j - 1]);
                            b.append(i+2);
                            b.append(" ");
                            b.append(j);
                        }
                        else{
                            array[i + 1][j + 1] = invert(array[i + 1][j + 1]);
                            b.append(i+2);
                            b.append(" ");
                            b.append(j+2);
                        }
                        answers.add(b.toString());
                    }
            
            
        }
    }
        
}
