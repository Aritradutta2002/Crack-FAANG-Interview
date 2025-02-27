import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 class RestoreSequence {
    static ArrayList<Integer> sieveOfEratosthenes(int n) 
    { 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            if(prime[p] == true) 
            { 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
          
        ArrayList<Integer>list =new ArrayList<>();
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) 
                list.add(i);
        } 
        return list;
    } 
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>list = sieveOfEratosthenes(5*1000000);
        int t1 = Integer.parseInt(r.readLine());
        
        while(t1-->0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int [] array = new int[n];
            for(int i =0;i<n;i++)
                array[i] = Integer.parseInt(t.nextToken())-1;
            int [] sol = new int [n];
            for(int i=0;i<n;i++)
                sol[i] = list.get(i);
            for(int i=0;i<n;i++)
                sol[i]=sol[array[i]];
            

                
        
            



            // HashMap <Integer,Integer> map = new HashMap<>();
            // int pos = 0;
            // for(int i=0;i<n;i++){
            //     if(sol[i]==-1)
            //         if(sol[array[i]] != -1){
            //             sol[i] = sol[array[i]];
            //             sol[array[i]]*=map.get(array[i]);
            //         }
            //         else{
            //             int mul = list.get(pos++);
            //             map.put(array[i], mul);
            //             sol[i] = mul;
            //             if(array[i]!=i)
            //                 sol[array[i]] = mul*mul;
                        
            //         }
            // }
            for(int i:sol)
                System.out.print(i+" ");
            System.out.println();
        }

    } 
}
