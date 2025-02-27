import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class PuttingBricksInWall {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]array=new String[n];
            for(int i=0;i<n;i++){
                array[i]=r.readLine();
            }
            ArrayList<String>list=new ArrayList<>();
            if(array[0].charAt(1)!='0')
                list.add("1 2");
            if(array[1].charAt(0)!='0')
                list.add("2 1");
            if(array[n-2].charAt(n-1)!='1')
                list.add((n-1)+" "+n);
            if(array[n-1].charAt(n-2)!='1')
                list.add((n)+" "+(n-1));

            ArrayList<String>list1=new ArrayList<>();
            if(array[0].charAt(1)!='1')
                list1.add("1 2");
            if(array[1].charAt(0)!='1')
                list1.add("2 1");
            if(array[n-2].charAt(n-1)!='0')
                list1.add((n-1)+" "+n);
            if(array[n-1].charAt(n-2)!='0')
                list1.add((n)+" "+(n-1));
            if(list.size()<list1.size()){
                System.out.println(list.size());
                for(String s:list)
                    System.out.println(s);
            }
            else{
                System.out.println(list1.size());
                for(String s:list1)
                    System.out.println(s);
            }
        }
    } 
}
