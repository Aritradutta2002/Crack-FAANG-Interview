import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class PerfectKeyboard {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            String s = r.readLine();
            int n = s.length();
            keyboard k = new keyboard();
        
            for(int i = 1; i < n; i++)
                k.add(s.charAt(i), s.charAt(i - 1));
            // System.out.println(k.list);
            if(k.check()){
                System.out.println("YES");
                String ans = k.get();
                StringBuilder  b = new StringBuilder();
                b.append(ans);
                boolean[]visited=new boolean[26];
                for(char c : ans.toCharArray())
                    visited[c - 'a'] = true;
                for(int i = 0; i < 26; i++)
                    if(!visited[i])
                        b.append((char)('a' + i));

                System.out.println(b);
            }
            else
                System.out.println("NO");

        }
        
    }
        
}

class keyboard{
    ArrayList<HashSet<Integer>> list;
    keyboard(){
        list = new ArrayList<>();
        for(int i = 0; i < 26; i ++)
            list.add(new HashSet<>());
    }

    void add(char c1, char c2){
        list.get(c1 - 'a').add(c2 - 'a');
        list.get(c2 - 'a').add(c1 - 'a');
    }

    boolean check(){
        for (HashSet<Integer> set : list){
            if(set.size() > 2)
                return false;
        }

        for(int i = 0; i < 26; i++)
            if(!checkVisit(i, -1))
                return false;
        return true;
    }

    boolean[]visited = new boolean[26];
    private boolean checkVisit(int pos,int parent){
        // System.out.println(pos);
        if(visited[pos])
            return true;

        visited[pos] = true;

        for(int child : list.get(pos)){
            if(child == parent)
                continue;
            if(visited[child])
                return false;
            else
                if(!checkVisit(child, pos))
                    return false;
            }
        return true;

    }
    StringBuilder b = new StringBuilder();
    String get(){
        int start = 0;
        for(int i = 0; i < 26; i ++)
            if(list.get(i).size() == 1){
                start = i;
                break;
            }
        traverse(start, -1);
        return b.toString();
        
    }
    void traverse(int current, int last){
        b.append((char)('a' + current));
        for(int child : list.get(current))
            if(child != last)
                traverse(child, current);
    }

}
