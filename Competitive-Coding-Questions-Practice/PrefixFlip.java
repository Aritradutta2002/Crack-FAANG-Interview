import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrefixFlip {
    public static void main(String[] args)throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String s1=r.readLine();
            String s2=r.readLine();
            ArrayList<Integer>list1=new ArrayList<>();
            ArrayList<Integer>list2=new ArrayList<>();
            if(s1.charAt(0)!='1')
                list1.add(1);
            for(int i=n-1;i>0;i--){
                if(s1.charAt(i)!='0')
                    list1.add(i+1);
            }
            if(s2.charAt(0)!='1')
                list2.add(1);
            for(int i=n-1;i>0;i--){
                if(s2.charAt(i)!='0')
                    list2.add(i+1);
            }
            if(list1.size()==0&&s1.charAt(0)!='0')
                list1.add(1);
            if(list2.size()==0&&s2.charAt(0)!='0')
                list2.add(1);
            System.out.print((list1.size()+list2.size())+" ");
            for(int i:list1)
                System.out.print(i+" ");
            for(int i=list2.size()-1;i>=0;i--){
                System.out.print(list2.get(i)+" ");
            }
            System.out.println();
            
        }
        
    }
    
}