import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class AppleJacks {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String[]data=r.readLine().split(" ");
        int[]array=new int[(int) (Math.pow(10, 5) + 10)];
        int fours=0,twos=0;
        Arrays.fill(array, 0);
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(data[i]);
            array[num]++;
            if(array[num]%4==0){
                fours++;
                twos--;
            }
            else if(array[num]%2==0)
                twos++;
        }
        int t=Integer.parseInt(r.readLine());
        // System.out.println(twos+" "+fours);
        while(t-->0){
            String []s=r.readLine().split(" ");
            int num=Integer.parseInt(s[1]);
            if(s[0].charAt(0)=='-'){
                array[num]--;
                if(array[num]%4==3){
                    fours--;
                    twos++;
                }
                else if(array[num]%2==1)
                    twos--;
            }
            else{
                array[num]++;
                if(array[num]%4==0){
                    twos--;
                    fours++;
                }
                else if(array[num]%2==0)
                    twos++;
            }
            // System.out.println("value is"+array[10]);
            // System.out.println(twos+" "+fours);
            if(fours>=2)
                System.out.println("YES");
            else if(fours>=1&&twos>=2)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    } 
}