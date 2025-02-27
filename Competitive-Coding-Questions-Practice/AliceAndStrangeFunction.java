import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class TestClass {
    static ArrayList<Integer> getFactor(int num){
        ArrayList<Integer>list = new ArrayList<>();
        if(num % 2 == 0 && num != 2){
            list.add(2);
            if(num != 4)
                list.add(num / 2);
            }
        for(int i = 3; (long)((long)i * (long)i) <= num ; i += 1)
            if(num % i == 0){
                if(num / i == i)
                    list.add(i);
                else{
                    list.add(i);
                    list.add(num / i);
                }
            }
        return list;
    }
    public static void main(String args[] ) throws IOException {
        long mod = 998244353;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000000;
        long[]array = new long[n + 10];
        long[]ans = new long[n + 10];
        for(int i = 2; i < n + 5; i ++){
            ArrayList<Integer> fact = getFactor(i);
            if(fact.size() == 0){
                array[i] = 1;
                ans[i] = 1;
                continue;
            } else {
                int j = fact.get(0);
                if(i == 9)
                    System.out.println(array[i]);
                array[i] = ((((long)(i/j) * ans[j] ) % mod + ((long)(j) * ans[i / j] )) % mod + array[i]) % mod;
                if(i == 9)
                    System.out.println(fact);;
                ans[i] = array[i];
                if(i == 16){
                    System.out.println(array[i]);
                    System.out.println(fact);
                }
            }

            
            for(int j : fact){
                array[i] = (array[i] + ans[j]) % mod;
            }
        }
        for(int j = 0 ; j< 20;j++){
            System.out.print(array[j] + " ");
        }
        System.out.println();
        for(int j = 0 ; j< 20;j++){
            System.out.print(ans[j] + " ");
        }
        System.out.println();
        for(int i = 2; i < n + 5; i ++)
            array[i] = (array[i] + array[i - 1]) % mod;
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int l = Integer.parseInt(t.nextToken());
            int rr = Integer.parseInt(t.nextToken());
            System.out.println((array[rr] - array[l - 1]));
        }

    }
}
// 0
// 1
// 1
// 5
// 1
// 7
// 1
// 17
// 7
// 9
// 1
// 27
// 1
// 11
// 10
// 49
// 1
// 34
// 1
// 37
