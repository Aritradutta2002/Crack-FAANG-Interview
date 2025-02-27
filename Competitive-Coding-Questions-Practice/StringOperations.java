import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;


 class StringOperations {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new java.io.InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        OutputStream outputStream =System.out;
        
        PrintWriter out =new PrintWriter(outputStream);
        while(t1 -- > 0){
            String s = r.readLine();
            int n = s.length();
            long count = 0;
            HashSet<ArrayList<Integer>>set = new HashSet<>();
            for(int end = 1; end <=n ;end ++){
                int sum = 0;
                int ones = 0;
                boolean add = false;
                for(int length = 1; end - length >= 0; length ++){
                    int start = end - length;
                    if(s.charAt(start) == '1'){
                        add = !add;
                        ones++;
                    }
                    else if(add)
                        sum++;
                    // int[]arr = {length, ones, sum};
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(length);
                    list.add(ones);
                    list.add(sum);
                    if(!set.contains(list)){
                        count++;
                        set.add(list);
                    }
                }
            }
            out.println(count);
        }
        out.close();
        
    }
        
}

