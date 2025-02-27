import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class PrinzessinDerVerurteilung {
    static boolean contains (String s1, String s2, int n1, int n2){
        for(int i = 0; i + n2 < n1; i ++){
            int pos = 0;
            boolean f = false;
            for(int j = i; j < i + n2; j ++)
                if(s1.charAt(j) != s2.charAt(pos++))
                    f = true;
            if(!f)
                return true;
        }

        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1= Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine().trim();

            int size = 100;
            String ans = "";
            for(int i = 'a'; i <= 'z'; i ++){
                String ss = Character.toString((char)i);
                if(!contains(s, ss, n, 1)){
                    ans = ss;
                    size = 1;
                }

                for(int j = 'a'; j <= 'z'; j ++){
                    if(!contains(s, ss + (char)j, n, 2) && size > 2){
                        ans = ss + (char)j;
                        size = 2;
                    }

                    for(int l = 'a'; l <= 'z'; l ++){
                        if(!contains(s, ss + (char)j + (char)l, n, 3) && size > 3){
                            ans = ss + (char)j + (char)l;
                            size = 3;
            
                        }
        
                    }
    
    
                }

            }

            System.out.println(ans);
        }
    }
        
}
