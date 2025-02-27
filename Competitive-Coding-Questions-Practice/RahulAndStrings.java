import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RahulAndStrings {
    static boolean check(String a, String b, int p1, int p2,int n1, int n2, int extra){
        if(p2 >= n2){
            
            return true;
        }
        if(p1 >= n1){
            if(extra!= -1 && p2 == n2 - 1)
                return true;
            return false;
        }

        char ac = a.charAt(p1);
        char bc = b.charAt(p2);

        if(Character.isLowerCase(ac)){

            if(Character.toLowerCase(bc) == ac)
                return check(a, b, p1 + 1, p2, n1, n2, p1);
            else{
                return check(a, b, p1 + 1, p2, n1, n2, extra);
            }
        } else {
            if(ac != bc){
                if(extra != -1){
                    return check(a, b, extra + 1, p2 + 1, n1, n2, -1);
                } else {
                    return false;
                }
            } else {
                if(extra != -1){
                    return (check(a, b, extra + 1, p2 + 1, n1, n2, -1) || check(a, b, p1 + 1, p2 + 1, n1, n2, -1));
                } else {
                    return check(a, b, p1 + 1, p2 + 1, n1, n2, -1);
                }
            }
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            String a = r.readLine().trim();
            String b = r.readLine().trim();
            int n1 = a.length();
            int n2 = b.length();

            boolean bb = check(a, b, 0, 0, n1, n2, -1);

            if(bb)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
        
}
