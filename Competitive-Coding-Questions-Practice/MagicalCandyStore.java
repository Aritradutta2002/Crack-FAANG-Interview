// import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
// import java.io.InputStreamReader;
import java.util.Arrays;
// import java.util.StringTokenizer;
 class MagicalCandyStore {
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
     
    public static void main(String[] args) throws IOException{
        // BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        Reader r = new Reader();
        // int t1 = Integer.parseInt(r.readLine());
        int t1=r.nextInt();
        long N=1000000007;
        while(t1-->0){
            long diff = 0;
            int n = r.nextInt();
            // StringTokenizer t = new StringTokenizer(r.readLine());
            long[]array = new long [n];
            for(int i = 0; i < n; i++)
                array [i] = r.nextLong();
            int q =r.nextInt();

            long [] cumsum = new long [n+1];
            if(array[0] == 1){
                Arrays.fill(cumsum, 1);
                cumsum[0] = 0;
            }
            else{
                for(int i=0;i<n-1;i++)
                    if(array[i] == 1){
                        if(array[i-1]%2==0)
                            cumsum[i]--;
                        else
                            cumsum[i]++;
                        cumsum[i+1] = cumsum[i];
                    } else{
                        cumsum[i+1] = array[i]-array[i]%2+cumsum[i];
                        // cumsum[i+1] %= N;
                    }
                diff = array[n-1]- (1-array[n-1]%2);
                cumsum[n] = cumsum[n-1] + array[n-1]- (1-array[n-1]%2);

            }
            // for(long i:cumsum)
            //     System.out.print(i+" ");
            // System.out.println();

            while(q-->0){
                long turns = r.nextLong()   ;
                long ans = (cumsum[n] * (turns / n)) % N;
                int pos = (int)turns % n;
                // System.out.println(ans);
                if(array[0]!=1){
                    pos--;
                    if(pos!=-1){
                        if(array[pos]==1){
                            ans+=cumsum[pos+1];
                        }
                        else
                            ans += array[pos]+cumsum[pos];
                    }
                    else
                        ans+=array[n-1]-diff;

                }
                else{
                    ans = (turns/n)%N;
                    if(turns%n>1)
                        ans++;
                    if(ans==0)
                        ans++;
                }
                ans%=N;
                System.out.println(ans);
                

            }

            // while(q-->0){
            //     long turns = Long.parseLong(r.readLine());
            //     long ans = (cumsum[n] * (turns / n)) % N;
            //     System.out.println(ans);   
            //     int pos = (int)turns % n;
            //     ans += cumsum[pos];
                
            //     // int pos1 = pos-1;
            //     // if(pos1 == -1)
            //     //     pos1 = n-1;
            //     System.out.println(pos+" !!!!");
            //     // System.out.println(pos1);
            //     if(array[0]!=1){
            //         ans+=array[pos];
            //         if(array[pos] ==1){
            //             // ans++;
            //             if(array[pos-1]%2==0)
            //                 ans++;
            //             else
            //                 ans--;
            //         }
            //     }
            //     // ans += array[pos1] - (cumsum[pos1+1] - cumsum[pos1]);

            //     ans %= N;
            //     System.out.println(ans);


            // }

        } 
    } 
}
