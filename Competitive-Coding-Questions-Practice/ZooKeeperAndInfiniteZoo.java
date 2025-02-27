import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZooKeeperAndInfiniteZoo {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n1 = Integer.parseInt(t.nextToken());
            int n2 = Integer.parseInt(t.nextToken());
            String s1 = Integer.toBinaryString(n1), s2 = Integer.toBinaryString(n2);
            int[]target = new int[32], start = new int[32];
            n1 = s1.length();
            n2 = s2.length();
            int p = 0;
            for(int i = n1 - 1; i >= 0; i --)
                start[p++] = Integer.parseInt(Character.toString(s1.charAt(i)));
            p = 0;
            for(int i = n2 - 1; i >= 0; i --)
                target[p++] = Integer.parseInt(Character.toString(s2.charAt(i)));
            
            int perm = 0, temp = 0;
            boolean c = true;
            
            for(int i = 0; i < 32; i ++){
                if(target[i] == 1 && start[i] == 0){
                    temp += perm;
                    perm = 0;
                    if(temp == 0)
                        c = false;
                    temp --;
                } else if(target[i] == 0 && start[i] == 1){
                    perm ++;
                }
            }

            if(perm > 0)
                c = false;
            if(c)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
        
}
