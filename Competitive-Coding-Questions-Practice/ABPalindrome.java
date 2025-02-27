import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABPalindrome {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0 ){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(t.nextToken());
            int b = Integer.parseInt(t.nextToken());
            char[]arr = r.readLine().toCharArray();
            int n = arr.length;
            boolean p = true;
            for(char c : arr)
                if(c == '0')
                    a--;
                else if(c == '1')
                    b--;
            for(int i = 0; i < n / 2 + n % 2; i ++){
                int j = n - 1 - i;
                char n1 = arr[i], n2 = arr[j];
                if(i == j)
                    continue;
                if(n1 == n2)
                    continue;
                else if(n1 =='1' && n2 == '0')
                    p = false;
                else if(n1 == '1' || n2 == '1'){
                    if( b > 0){
                        b--;
                        if(n1 == '?')
                            arr[i] = '1';
                        else
                            arr[j] = '1';
                    }
                    else
                        p = false;
                }
                else if(n1 == '0' || n2 == '0'){
                    if( a > 0){
                        a--;
                        if(n1 == '?')
                            arr[i] = '0';
                        else
                            arr[j] = '0';
                    }
                    else
                        p = false;
                }
                

            }
            for(int i = 0; i < n / 2 + n % 2; i ++){
                int j = n - 1 - i;
                if(arr[i] == '?'){
                    if(i == j){
                        if(a > 0){
                            a--;
                            arr[i] = '0';
                        } else if(b > 0){
                            b--;
                            arr[i] = '1';
                        }
                        else
                            p = false;
                    } else {
                        if(a > 1){
                            a-= 2;
                            arr[i] = '0';
                            arr[j] = '0';
                        } else if(b > 1){
                            b-=2;
                            arr[i] = '1';
                            arr[j] = '1';
                        }
                        else
                            p = false;
                    }
                }
            }    

            if(!p || a != 0 || b!= 0){
                System.out.println(-1);
            } else {
                StringBuilder bbb = new StringBuilder();
                for(char c : arr)
                    bbb.append(c);
                System.out.println(bbb);
            }
        }
    }
        
}
