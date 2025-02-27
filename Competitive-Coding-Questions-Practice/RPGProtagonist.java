import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RPGProtagonist {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data1=r.readLine().split(" ");
            String[]data2=r.readLine().split(" ");
            String[]data3=r.readLine().split(" ");
            int c1=Integer.parseInt(data1[0]);
            int c2=Integer.parseInt(data1[1]);
            int max1=Integer.parseInt(data2[0]);
            int max2=Integer.parseInt(data2[1]);
            int w1=Integer.parseInt(data3[0]);
            int w2=Integer.parseInt(data3[1]);
            if(w1>w2){
                int temp=w1;
                w1=w2;
                w2=temp;
                max1=temp;
                max1=max2;
                max2=temp;
            }
            int diff=w2-w1;
            int count=0;
            if(diff!=0){
                int remove1count=Math.min(max1,c1/w1);
                max1-=remove1count;
                c1-=remove1count*w1;
                count+=remove1count;
                int remove2count=Math.min(max2,c1/w2);
                max2-=remove2count;
                c1-=remove2count*w2;
                count+=remove2count;
                remove2count=Math.min(c1/diff, max2);
                c1-=remove2count*diff;
                max2-=remove2count;
                max1+=remove2count;

                remove1count=Math.min(max1,c2/w1);
                max1-=remove1count;
                c2-=remove1count*w1;
                count+=remove1count;
                remove2count=Math.min(max2,c2/w2);
                count+=remove2count;
                max2-=remove2count;
                c2-=remove2count*w2;
                remove2count=Math.min(c2/diff, max2);
                c2-=remove2count*diff;
                max2-=remove2count;
                max1+=remove2count;
                System.out.println(count);
            }
            else{
                max1+=max2;
                count+=Math.min(max1, c1/w1);
                max1-=count;
                count+=Math.min(max1, c2/w1);
                System.out.println(count);
            }
        }
    } 
}