import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class CompressAllSubsequences{
    static String getProduct(String s1,String s2){
        if(s1.equals(s2))
            return "0";
        if(s1.length()==s2.length()){
            int pos1=Integer.MAX_VALUE;
            boolean found=false;
            for(int i=s1.length()-1;i>=0;i--){
                if(s1.charAt(i)!=s2.charAt(i)&&!found){
                    pos1=i;
                }
                else if(s1.charAt(i)!=s2.charAt(i)){
                    found=true;
                    break;
                }
            }
            String s="1";
            int n=s1.length()-pos1-1;
            if(!found)
                n--;
            for(int i=0;i<n-1;i++)
                s+="0";
            return s;
        }
        String s="1";
        int n=Math.max(s1.length(), s2.length());
        for(int i=0;i<n-1;i++)
            s+="0";
        return s;
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        long[]array=new long[n];
        StringTokenizer t=new StringTokenizer(r.readLine());
        for(int i=0;i<n;i++)
            array[i]=Long.parseLong(t.nextToken());
        String[]bs=new String[n];
        for(int i=0;i<n;i++)
            bs[i]=Long.toBinaryString(array[i]).trim();
        long sum=0;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                if(j==i+1){
                    sum+=Long.parseLong(getProduct(bs[i], bs[i+1]),2);
                }
                int maxPos=0;
                long max=0;
                for(int k=i;k<=j;k++)
                    if(array[k]>max){ 
                        maxPos=k;
                        max=array[k];
                    }
                String s=bs[i];
                if(maxPos==i)
                    s=bs[i+1];
                for(int k=i+1;k<=j;k++){
                    if(k==maxPos)
                        continue;
                    s=getProduct(s,bs[k]);
                }
                
                sum+=Long.parseLong(getProduct(s, bs[maxPos]),2);
            }
        System.out.println(sum%998244353);
            
    } 
}