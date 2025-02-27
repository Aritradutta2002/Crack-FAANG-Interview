import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;

class PrimeGame {

    static class Reader {
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
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
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
            } while ((c = read()) >= '0' && c <= '9');
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
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
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

    static ArrayList<Integer> sieveOfEratosthenes(int n)
    {
        // Create a boolean array 
        // "prime[0..n]" and
        // initialize all entries 
        // it as true. A value in
        // prime[i] will finally be 
        // false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++) 
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) 
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        ArrayList<Integer>list = new ArrayList<>();
        // list.add(-1);
        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {   
            if (prime[i] == true)
                list.add(i);
        }
        return list;
    }
    static ArrayList<Integer> list;
    static int getPos(int x){
        int max = list.size();
        int min = 0;
        int ans = 0;
        while(max >= min){
            int mid = min + (max - min) / 2;
            if(list.get(mid) > x)
                max = mid - 1;
            else {
                min = mid + 1;
                ans = min;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        Reader r = new Reader();
        int t1 = r.nextInt();
        list = sieveOfEratosthenes(1000000+100); 
        BufferedWriter out = new BufferedWriter( 
            new OutputStreamWriter(System.out)); 
        // System.out.println(list);
        while(t1 -- > 0){
            // StringTokenizer t = new StringTokenizer(r.readLine());
            int x = r.nextInt();
            int y = r.nextInt();
            int pos = getPos(x);
            // System.out.println(pos);
            if(pos > y)
               out.write("Divyam");
            else
                out.write("Chef");
            out.newLine();
        } 
        out.flush();
    }

        
}
