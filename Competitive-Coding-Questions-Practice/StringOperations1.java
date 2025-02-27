import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class StringOperations1 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(r.readLine());
        while(t -- > 0){
            String s = r.readLine();
            int n=s.length();
            HashMap<String, int[]>m1 = new HashMap<>();
            HashMap<int[], String> m = new HashMap<>();
            HashSet<String>v = new HashSet<>();
            String arr[] = new String[n*(n+1)/2];
            String a="";
            long cc = 0;
            for(int len=1;len<=n;len++) 
            {    
                boolean[][]visited = new boolean[n + 1][n + 1];
                for(int i=0;i<=n-len;i++) 
                {
                    if(!m1.containsKey(s.subSequence(i, i + len))&&s.subSequence(i, i + len).length()!=n){
                        int j=i+len-1; 
                    a="";
                    int flag=0;
                    int c=0;
                    int cnt=0;
                    int ans=0;
                    int o=0;
                    int p=i;
                    int i1=i;
                    int i2=j;
                    a="";
                    flag=0;
                    c=0;
                    cnt=0;
                    ans=0;
                    o=0;
                    p=i;
                    i1=i;
                    i2=j;
                    int start = i;
                    int end = start + len;
                    int x = end - 1;
                    int sum = 0;
                    boolean add = true;
                    while(x >=start){
                        if(s.charAt(x) == '0'){
                            x --;
                            continue;
                        }
                        int y =  x - 1;
                        while(y >= start){
                            if(s.charAt(y) == '0'){
                                y--;
                                continue;
                            }
                            else
                                break;
                        }
                        if(add)
                            sum += x - y;
                        add = !add;
                        x = y;
                    }    
                    for (int k=j;k>=i;k--) 
                    {
                        if(s.charAt(i)=='1' && flag==0)
                        {
                            flag=1;
                            i1=k-i;
                            o++;
                        }
                        else if(s.charAt(i)=='1')
                        {
                            i2=k-i;
                            cnt++;
                            if(cnt%2!=0)
                            {
                                ans+=Math.abs(i1 - i2);
                            }
                            i1=i2;
                            o++;
                        }
                        a=a+s.charAt(p++);
                    }
                    if(cnt%2==0)
                    {
                        ans+=Math.abs(i1);
                    }
                    int[]array = {ans, o, a.length()};
                    if(!m.containsKey(array) && !m1.containsKey(a))
                    {
                        m.put(array, a);
                        m1.put(a, array);
                    }
                    // int[]aa={ans,o,a.length()};
                    // m.put(a, aa);
                    // v.add(a);
                    // if(!visited[ans][o]){
                    //     visited[ans][o] = true;
                    //     cc++;

                    // }
                    // System.out.println(a+" "+ans);
                    //cout<<a<<" "<<ans<<endl;
                    }
                }
            }
        
            // System.out.println();
         
        System.out.println((m.size() + 1));
        }
    }
        
}
