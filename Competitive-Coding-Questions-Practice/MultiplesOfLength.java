import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MultiplesOfLength {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String[]data=r.readLine().split(" ");
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(data[i]);
        if(n==1){
            System.out.println(1+" "+1);
            System.out.println(1);
            System.out.println(1+" "+1);
            System.out.println(-1);
            System.out.println(1+" "+1);
            System.out.println(-(array[0]));
            return;
        }
        if(n==2){
            System.out.println(1+" "+2);
            System.out.println(2+" "+2);
            System.out.println(1+" "+1);
            System.out.println(-(array[0]+2));
            System.out.println(2+" "+2);
            System.out.println(-(array[1]+2));
            return;
        }
        System.out.println(1+" "+n);
        for(int i:array)
            if(i==0)
                System.out.print(0+" ");
            else if(i>0)
                System.out.print((Math.abs((long)i)*-n)+" ");
            else
                System.out.print((n*Math.abs((long)i))+" ");
        System.out.println();
        System.out.println(1+" "+(n-1));
        for(int i=0;i<n-1;i++)
            if(array[i]==0)
                System.out.print(0+" ");
            else if(array[i]>0)
                System.out.print(((long)array[i]*(long)(n-1))+" ");
            else
                System.out.print(((long)array[i]*(n-1))+" ");
        System.out.println();
        System.out.println(n+" "+n);
        System.out.println(-(array[n-1]-(long)array[n-1]*n));
    } 
}