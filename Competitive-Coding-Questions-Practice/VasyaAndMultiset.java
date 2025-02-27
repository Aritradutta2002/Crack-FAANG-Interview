import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class VasyaAndMultiset {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        StringTokenizer t=new StringTokenizer(r.readLine());
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(t.nextToken());
        // int count=1;
        int[]freq=new int[101];
        // Arrays.sort(array);
        // int last=array[0];
        for(int i:array){
            freq[i]++;
        } 
        // freq[array[n-1]]=count;
        int comp=0;
        int poss=0;
        for(int i:freq)
            if(i==1)
                comp++;
            else if(i>=3)
                poss++;
        if(comp%2==1&&poss==0){
            System.out.println("NO");
            return;
        }
        boolean needposs=comp%2==1;
        boolean l=true;
        StringBuilder b=new StringBuilder();
        for(int i:array){
            if(freq[i]==1){
                if(l)
                    b.append("A");
                else
                    b.append("B");
                
                l=!l;

            }
            else if(freq[i]>2&&needposs){
                b.append("B");
                needposs=false;
            }
            else
                b.append("A");
        }
        System.out.println("YES");
        System.out.println(b);

    } 
}
