import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
public class AsSimpleAsOneTwo {
    static boolean check(int pos,int n,String s){
        boolean b1=false;
        boolean b2=false;
        if(pos>=2)
            b1=s.charAt(pos-1)=='w'&&s.charAt(pos-2)=='t';
        if(n-pos>=3)
            b2=s.charAt(pos+1)=='n'&&s.charAt(pos+2)=='e';
        return b1&&b2;
    }
    static boolean check2(int pos,int n,String s){
        if(pos==0||pos==n-1)
            return false;
        boolean b1=s.charAt(pos-1)=='o'&&s.charAt(pos+1)=='e';
        
        return b1;
    }
    static boolean check3(int pos,int n,String s){
        if(pos==0||pos==n-1)
            return false;
        boolean b1=s.charAt(pos-1)=='t'&&s.charAt(pos+1)=='o';
        
        return b1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            String s=r.readLine();
            int n=s.length();
            HashSet<Integer>list=new HashSet<>();
            for(int i=0;i<n;i++)
                if(s.charAt(i)=='o')
                    if(check(i, n, s)){
                        list.add(i+1);
                    }
            
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='w')
                    if(check3(i, n, s)&&!list.contains(i+2))
                        list.add(i+1);
                if(s.charAt(i)=='n')
                    if(check2(i, n, s)&&!list.contains(i))
                        list.add(i+1);
            }
            System.out.println(list.size());
            for(int i:list)
                System.out.print(i+" ");
            System.out.println();
        } 
    } 
}
