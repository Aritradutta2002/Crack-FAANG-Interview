import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class SubstringRemovalGame {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine();
            int n=s.length();
            ArrayList<Integer>list=new ArrayList<>();
            int count=0;
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                if(c=='0'&&count!=0){
                    list.add(count);
                    count=0;
                }
                if(c=='1')
                    count++;
            }
            if(count!=0)
                list.add(count);
            Collections.sort(list,Collections.reverseOrder());
            int size=list.size();
            int sum=0;
            for(int i=0;i<size;i+=2)
                sum+=list.get(i);
            System.out.println(sum);
        }
    } 
}