import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class SocialDistance {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data1=r.readLine().split(" ");
            int n=Integer.parseInt(data1[0]);
            int k=Integer.parseInt(data1[1]);
            String s=r.readLine();
            if(n<=k){
                boolean check=true;
                for(int i=0;i<n;i++)
                    if(s.charAt(i)=='1'){
                        check=false;
                        break;
                    }
                if(check)
                    System.out.println(1);
                else
                    System.out.println(0);
                continue;
            }
            ArrayList<Integer>list=new ArrayList<>();
            int count=0;
            int left=0,right=n-1;
            while(s.charAt(left)=='0'){
                left++;
                if(left==n)
                    break;
            }
            while(s.charAt(right)=='0'){
                right--;
                if(right<0)
                    break;
            }
            for(int i=left;i<right;i++){
                char c=s.charAt(i);
                if(c=='0')
                    count++;
                else
                    if(count!=0){
                        list.add(count);
                        count=0;
                    }
            }
            if(count!=0)
                list.add(count);
            int sum=0;
            k++;
            for(int i:list){
                sum+=i/k;
                if(i%k==0)
                    sum--;
            }
            sum+=left%k;
            sum+=right%k;
            
            if(left==n-1){
                sum+=n/k;
                if(n%k!=0)
                    sum++;
                }
            System.out.println(sum);
        } 
    } 
}
