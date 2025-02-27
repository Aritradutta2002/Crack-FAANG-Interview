import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 class IronMagnetAndWall {
    static int getNextIron(int current,String s,int n){
        for(int i =current+1;i<n;i++)
            if(s.charAt(i)=='I'||s.charAt(i)=='X')
                return i;
        return Integer.MAX_VALUE-100;
                
    }
    static int getNextMagnet(int current,String s,int n){
        for(int i =current+1;i<n;i++)
            if(s.charAt(i)=='M'||s.charAt(i)=='X')
                return i;
        return Integer.MAX_VALUE-100;
                
    }
    static boolean isPossible(int k,int i,int j,int sheets){
        int val = k+1-Math.abs(i-j)-sheets;
        return val>0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            
            int k = Integer.parseInt(t.nextToken());
            String s = r.readLine();
            int []sheetCount = new int[n+1];
            for(int i=0;i<n;i++){
                sheetCount[i+1]=sheetCount[i];
                if(s.charAt(i)==':')
                    sheetCount[i+1]++;
            }
            int magnetPos = getNextMagnet(-1, s, n);
            int ironPos = getNextIron(-1, s, n);

            int count = 0;
            while(true){
                if(Math.max(magnetPos, ironPos)<n){
                    if(s.charAt(Math.max(magnetPos, ironPos))=='X'){
                        int p = ironPos;
                        ironPos = getNextIron(Math.max(magnetPos, ironPos), s, n);
                        magnetPos = getNextMagnet(Math.max(magnetPos, p), s, n);
                    }
                    else
                        break;
                }
                else
                    break;
            }
            while(magnetPos<n&&ironPos<n){
                int sheets = sheetCount[Math.max(magnetPos,ironPos)+1] - sheetCount[Math.min(magnetPos, ironPos)];
                if(isPossible(k, magnetPos, ironPos, sheets)){
                    count++;
                    magnetPos = getNextMagnet(magnetPos, s, n);
                    ironPos = getNextIron(ironPos, s, n);
                }
                else{
                    if(magnetPos>ironPos)
                        ironPos = getNextIron(ironPos, s, n);
                    else
                        magnetPos = getNextMagnet(magnetPos, s, n);
                }
                while(true){
                    if(Math.max(magnetPos, ironPos)<n){
                        if(s.charAt(Math.max(magnetPos, ironPos))=='X'){
                            int p = ironPos;
                            ironPos = getNextIron(Math.max(magnetPos, ironPos), s, n);
                            magnetPos = getNextMagnet(Math.max(magnetPos, p), s, n);
                        }
                        else
                            break;
                    }
                    else
                        break;
                }
            }
            System.out.println(count);

        }
    } 
}
