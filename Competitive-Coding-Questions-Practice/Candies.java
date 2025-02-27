import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Candies {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int m=Integer.parseInt(data[0]);
            int n=Integer.parseInt(data[1]);
            int max1,max2,min1,min2;
            if(m%2!=0)
                max1=m/2+1;
            else
                max1=m/2;
            if(n%2==0)
                max2=n/2+1;
            else
                max2=n/2;
            min1=m-max1;
            min2=n-max2;
            int num1,num2;
            int x=Integer.parseInt(data[2]);
            int y=Integer.parseInt(data[1]);
            num1=x;
            num2=y-x;
            if(x>y){
                num1=y;
                num2=0;
            }
            if(num2>num1){
                int temp=num1;
                num1=num2;
                num2=temp;
            }
            System.out.println(max1+" "+max2+" "+num1);
            long l=num1*max1*max2*n/2+num2*min1*min2*n/2;
            System.out.println(l);
        }
    }
}