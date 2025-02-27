
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

 class HailXOR {
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
        Reader r = new Reader();
        int t1 = r.nextInt();
        OutputStream outputStream =System.out;
        
        PrintWriter out =new PrintWriter(outputStream);
        while(t1 -- > 0){
            int n = r.nextInt();
            long x = r.nextLong();
            long[]array = new long[n];
            for(int i = 0; i < n; i ++)
                array[i] = r.nextInt();

            if(x == 0 || n==1){
                StringBuilder b = new StringBuilder();
                for(long i : array){
                    b.append(i);
                    b.append(" ");
                }
                out.println(b.toString());
            }

            int m = 33;

            boolean [][] mem = new boolean[n][m];

            for(int i = 0; i < n; i ++){
                String s = Long.toBinaryString(array[i]);
                int size = s.length();
                int ptr = m - 1;
                for(int j = size - 1; j >= 0; j --)
                    mem[i][ptr -- ] = s.charAt(j) == '1';    
            }
            int[]ptrs = new int[m];
            Arrays.fill(ptrs, 1);

            for(int i = 0; i < n - 1 && x > 0; i ++){
                for(int j = 0; j  < m && x > 0; j++){
                    if(mem[i][j] && x > 0){
                        for(ptrs[j] = Math.max(ptrs[j], i + 1); ptrs[j] < n; ptrs[j] ++)
                            if(mem[ptrs[j]][j])
                                break;
                        ptrs[j] = Math.min(ptrs[j], n - 1);
                        mem[ptrs[j]][j] = !mem[ptrs[j]][j];
                        mem[i][j] = false;
                        ptrs[j]++;
                        x--;
                    }
                    
                }
            }
            if(x % 2 == 1 && n <= 2){
                mem[n - 1][m - 1] = !mem[n - 1][m - 1];
                mem[n - 2][m - 1] = !mem[n - 2][m - 1];
            }
            for(int i = 0; i < n ;i ++){
                boolean[]current = mem[i];
                StringBuilder b = new StringBuilder();
                for(boolean bool : current)
                    b.append((bool) ? 1 : 0 );
                array[i] = Integer.parseInt(b.toString(), 2);
            }

            StringBuilder b = new StringBuilder();
            for(long i : array){
                b.append(i);
                b.append(" ");
            }
            out.println(b.toString());
            
        }
        out.close();
    }
        
}
