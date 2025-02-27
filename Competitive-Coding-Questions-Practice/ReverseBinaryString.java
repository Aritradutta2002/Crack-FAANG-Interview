import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReverseBinaryString {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            int n=Integer.parseInt(r.readLine());
            String s=r.readLine().trim();
            StringBuilder b1 = new StringBuilder();
            StringBuilder b2 = new StringBuilder();
            boolean b = true;
            for(int i = 0; i <n; i++){
                if(b){
                    b1.append(1);
                    b2.append(0);
                } else {
                    b1.append(0);
                    b2.append(1);
                }
                b =! b;
            }
            String s1 = b1.toString();
            String s2 = b2.toString();
            
            int count1 = 0;
            int i = 0;
            while(i < n){
                if(s.charAt(i) == s1.charAt(i)){
                    i++;
                    continue;
                }

                int j = i + 1;
                while(j < n){
                    if(s.charAt(j) == s1.charAt(j))
                        break;
                    j++;
                }
                i = j + 1;
                count1++;
                
                
            }

            int count2 = 0;
            i = 0;
            while(i < n){
                if(s.charAt(i) == s2.charAt(i)){
                    i++;
                    continue;
                }

                int j = i + 1;
                while(j < n){
                    if(s.charAt(j) == s2.charAt(j))
                        break;
                    j++;
                }
                i = j + 1;
                count2++;
                
                
            }

            System.out.println(Math.min(count1, count2));

        } 
    } 
}
