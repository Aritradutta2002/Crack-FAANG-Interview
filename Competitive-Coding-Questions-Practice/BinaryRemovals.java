import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
 
public class BinaryRemovals {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            String s = r.readLine().trim();
            int n = s.length();
            ArrayList<Integer>list = new ArrayList<>();
            int lastPos = -100;
            boolean rem = true;
            for(int i = 0; i < n; i ++){
                char c = s.charAt(i);
                if(rem && c == '1'){
                    if(i - lastPos != 1){
                        lastPos = i;
                    } else{
                        list.add(1);
                        rem = false;
                    }
                } else if(!rem && c == '0'){
                    if(i - lastPos != 1){
                        lastPos = i;
                    } else{
                        list.add(0);
                    }
                }
                
                else {
                    list.add(Integer.parseInt(Character.toString(c)));
                }
            }
            ArrayList<Integer>cpy = new ArrayList<>(list);
            boolean c1 = true;
            int l = cpy.size();
            Collections.sort(list);
            
            for(int i = 0; i < l; i ++)
                if(list.get(i) != cpy.get(i))
                    c1 = false;
            if(c1)
                System.out.println("YES");
            else
                System.out.println("NO");
 
                  
 
        }
    }
        
}