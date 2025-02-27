import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class FriendsAndGifts {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String[]data=r.readLine().split(" ");
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(data[i]);
        int[]selected=new int[n];
        for(int i:array)
            if(i==0) continue;
            else
                selected[i-1]=1;
        LinkedList<Integer>list=new LinkedList<>();
        for(int i=0;i<n;i++)
            if(selected[i]==0)
                list.add(i+1);
        System.out.println(list);
        for(int i=0;i<n;i++)
            if(array[i]!=0)
                System.out.print(array[i]+" ");
            else
                if(list.getFirst()==i+1){
                    System.out.print(list.get(1)+" ");
                    list.remove(1);
                }
                else{
                    System.out.print(list.getFirst()+" ");
                    list.removeFirst();
                }
        
    } 
}