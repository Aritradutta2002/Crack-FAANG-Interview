import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class StringDeletion {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String s=r.readLine().trim();
            ArrayList<Integer>list=new ArrayList<>();
            char last=s.charAt(0);
            int count=0;
            for(int i=1;i<n;i++){
                if(s.charAt(i)==last)
                    count++;
                else{
                    list.add(count);
                    count=0;
                    last=s.charAt(i);
                }
            }
            list.add(count);
            int size=list.size();
            int[]available=new int[size];
            available[size-1]=list.get(size-1);
            for(int i=size-2;i>=0;i--)
                available[i]=available[i+1]+list.get(i);
            int removed=0;
            count=0;
            for(int i=0;i<size;i++){
                if(i==size-1){
                    count++;
                    continue;
                }
                if(available[i]-removed>0){
                    count++;
                    removed++;
                    removed-=Math.min(removed, list.get(i));
                    continue;
                }
                if(i!=size-1){
                    count++;
                    removed-=Math.min(removed, list.get(i));
                    i++;
                    removed-=Math.min(removed, list.get(i));
                    continue;
                }
            }
            System.out.println(count);
            
        } 
    } 
}
