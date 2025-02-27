import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class ORofANDs {
    static int print(int[]array){
        int ans = 0;
        for(int i = 0; i < 33; i ++)
            if(array[i] > 0)
                ans += Math.pow(2, i);
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());
            int[]array = new int[n];
            t = new StringTokenizer(r.readLine());
            int[]or = new int[33];
            for(int i = 0; i < n ; i ++){
                array[i] = Integer.parseInt(t.nextToken());
                int num = array[i];
                for(int j = 0; j < 32; j ++){
                    if(num % 2 == 1)
                        or[j] ++;
                    num /= 2;
                }
                    

            }
            // for(int i = 0 ; i< 33; i ++)
            //     System.out.print(or[i] + " ");
            // System.out.println();
            int ans = print(or);
            for(int i = 0; i < q; i ++){
                t = new StringTokenizer(r.readLine());
                int pos = Integer.parseInt(t.nextToken()) - 1;
            
                for(int j = 0; j < 32; j ++)
                    if(array[pos] % 2 == 1){
                        or[j] --;
                        array[pos] /= 2;
                    }

                int num = Integer.parseInt(t.nextToken()); 
                array[pos] = num;
                for(int j = 0; j < 32; j ++)
                    if(num % 2 == 1){
                        or[j] ++;
                        num /= 2;
                    }
                        // for(int j = 0 ; j< 33; j ++)
                    //     System.out.print(or[j] + " ");
                    // System.out.println();
                print(or);


            }


        }
    }
        
}
