import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FlamingoesOfMystrey {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        int[]sums=new int[n];
        for(int i=2;i<=n;i++){
            System.out.println("? 1 "+i);
            System.out.flush();
            sums[i-1]=Integer.parseInt(r.readLine());
        } 
        int[]nums=new int[n];
        for(int i=2;i<n;i++)
            nums[i]=sums[i]-sums[i-1];
        System.out.println("? 2 3");
        System.out.flush();
        int twoToThree=Integer.parseInt(r.readLine());
        nums[0]=sums[2]-twoToThree;
        nums[1]=sums[1]-nums[0];
        System.out.print("! ");
        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();

    } 
}
