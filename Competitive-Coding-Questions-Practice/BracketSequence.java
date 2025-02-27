import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class BracketSequence {
    static String getCompressed(String s){
        Queue<Character>q=new LinkedList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(q.isEmpty())
                q.add(c);
            else
                if(q.peek()!=c)
                    q.remove();
                else
                    q.add(c);
        }
        StringBuilder b=new StringBuilder();
        for(Character c:q)
            b.append(c);
        return b.toString();
    }
    static boolean compare(String s1,String s2){
        int n1=s1.length();
        int n2=s2.length();
        if(n1!=n2){return false;}
        for(int i=0;i<n1;i++){
            if(s1.charAt(i)==s2.charAt(i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String[]array=new String[n];
        for(int i=0;i<n;i++)
            array[i]=getCompressed(r.readLine().trim());
        int count=0;
        // for(String l:array)
        //     System.out.println(l);
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(compare(array[i], array[j])){
                    System.out.println(array[i]+" "+array[j]);
                    count++;
                }
        System.out.println(count);

    } 
}