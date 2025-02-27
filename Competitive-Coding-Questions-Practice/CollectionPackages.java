import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class CollectionPackages {
    static String solution(HashMap<Integer,ArrayList<Integer>> map){
        for(Integer key:map.keySet()){
            Collections.sort(map.get(key));
        }
        int lastY=0;
        int lastX=0;
        StringBuilder b=new StringBuilder();
        for(int key:map.keySet()){
            for(int i=0;i<(key-lastX);i++)
                b.append("R");
            lastX=key;
            for(int y:new TreeSet<>(map.get(key))){
                if(y<lastY)
                    return "NO";
                else{
                    for(int i=0;i<(y-lastY);i++)
                        b.append("U");
                    lastY=y;
                }
            }
        }
        return b.toString();
    }
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int count=Integer.parseInt(r.readLine());
            HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
            for(int i=0;i<count;i++){
                String[]data=r.readLine().split(" ");
                int x,y;
                x=Integer.parseInt(data[0]);
                y=Integer.parseInt(data[1]);
                if(map.containsKey(x))
                    map.get(x).add(y);
                else{
                    map.put(x, new ArrayList<>());
                    map.get(x).add(y);
                }
            }
            String s=solution(map);
            if(s.equals("NO"))
                System.out.println(s);
            else{
                System.out.println("YES");
                System.out.println(s);
            }
        }
    }
    
}
