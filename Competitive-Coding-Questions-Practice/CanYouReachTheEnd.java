import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class CanYouReachTheEnd {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            ArrayList<Integer> [] a = new ArrayList[n];
            ArrayList<Integer> [] b = new ArrayList[n];
            for(int i = 0; i < n; i ++)
                a[i] = new ArrayList<Integer>();
            for(int i = 0; i < n; i ++)
                b[i] = new ArrayList<Integer>();
            for(int i = 0; i < n; i ++){
                StringTokenizer t = new StringTokenizer(r.readLine());
                int y = Integer.parseInt(t.nextToken());
                int x = Integer.parseInt(t.nextToken());
                a[x - 1].add(y);
                b[y - 1].add(x);
            }
            HashSet<Integer>s = new HashSet<>();
            for(int i : a[0])
                s.add(i);

            for(int i = 1; i < n; i ++){
                if(s.contains(1))
                    break;
                HashSet<Integer>temp = new HashSet<>();
                HashSet<Integer>l = new HashSet<>();
                for(int j : a[i])
                    l.add(j);

                // System.out.println(s);
                // System.out.println(l);
                for(int j : a[i])
                    if(s.contains(j)||s.contains(j + 1)||s.contains(j - 1)){
                        temp.add(j);
                        for(int k = j - 1; k >= 0; k--)
                            if(l.contains(k))
                                temp.add(k);
                            else
                                break;
                        for(int k = j + 1; k <= n; k++)
                            if(l.contains(k))
                                temp.add(k);
                            else
                                break;
                    }
                s = temp;
                // System.out.println(s);
                // System.out.println("~~~~~~~~~~");
            }
            
            if(s.isEmpty()){
                s = new HashSet<>();
                for(int i : b[0])
                    s.add(i);

                for(int i = 1; i < n; i ++){
                    if(s.contains(n))
                        break;
                    HashSet<Integer>temp = new HashSet<>();
                    HashSet<Integer>l = new HashSet<>();
                    for(int j : b[i])
                        l.add(j);

                    // System.out.println(s);
                    // System.out.println(l);
                    for(int j : b[i])
                        if(s.contains(j)||s.contains(j + 1)||s.contains(j - 1)){
                            temp.add(j);
                            for(int k = j - 1; k >= 0; k--)
                                if(l.contains(k))
                                    temp.add(k);
                                else
                                    break;
                            for(int k = j + 1; k <= n; k++)
                                if(l.contains(k))
                                    temp.add(k);
                                else
                                    break;
                        }
                    s = temp;
                }
                if(s.isEmpty())
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            else
                System.out.println("NO");
        }
    }
        
}

// 1
// 5
// 2 1
// 3 2
// 2 3
// 2 4
// 1 4