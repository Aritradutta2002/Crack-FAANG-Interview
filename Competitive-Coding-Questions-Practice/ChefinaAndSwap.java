import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
 class ChefinaAndSwap {
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

    static long getCount(long pos,long n,long sum){
        long pos2=Math.min(n, pos+sum);
        long pos1=Math.max(sum+1,pos+1);
        if(pos2<pos1)
            return 0;
        return (pos2-pos1)+1;
    
    }
    static long get(long n){
        long b=n+1;
        if(b%2==0)
            b/=2;
        else
            n/=2;
        return n*b;

    }
    public static void main(String[] args) throws IOException{
        Reader r=new Reader();
        int t=r.nextInt();
        while(t-->0){
            long n=r.nextLong();
            // System.out.println(sum);
            if(n%4!=0&&(n+1)%4!=0){
                System.out.println(0);
                continue;
            }
            
            long sum=get(n);
            long count=0;
            double start=(-1.0+(double)Math.sqrt(1+4*sum))/2.0;
            // System.out.println(start);
            int l=Math.max((int)start-1, 0);
            // int c=0;
            for(int i=l;i<l+10;i++){
                long num=get(i);
                long diff=(sum-num)-num;
                // System.out.println(i+" "+diff);
                // if(diff>n-1||diff<0)
                //     break;
                if(diff/2<0)
                    break;
                if(diff==0)
                    count+=(get(i-1)+get(n-i-1));
                else count+=getCount(i, n, (int)(diff/2));
            }
            System.out.println(count);
            
        } 
        r.close();
    } 
}
