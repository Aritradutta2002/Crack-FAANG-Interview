import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class TreeHouse {
    
    static class Node {
        int n;
        ArrayList<Integer>children;

        Node (int n) {
            this.n = n;
            children = new ArrayList<>();
        }
    }

    static class Pair {
        int pos;
        long cnt;

        Pair(int pos, long cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    static class Tree {
        long mod = 1000000000 + 7;
        Node [] arr;
        long [] cnt;
        long [] height;
        boolean [] visited; 
        Tree (int n) {
            arr = new Node[n];
            for(int i = 0; i < n; i ++)
                arr[i] = new Node(i);
            cnt = new long[n];
            height = new long[n];
            visited = new boolean[n];
        }

        long getCnt(int pos){
            visited[pos] = true;
            long s = 1;
            for(int child : arr[pos].children)
                if(!visited[child])    
                    s += getCnt(child);
            return cnt[pos] = s;
        }

        long getHeight(int pos, long h){
            visited[pos] = true;
            
            long s = Math.max(arr[pos].children.size() - 1, 0) * h;
            if(arr[pos].children.size() > 1)
                h++;
            for(int child : arr[pos].children)
                if(!visited[pos])    
                    s += getHeight(child, h);
            return height[pos] = s;

        }


        long getAns(int pos, long x){
            visited[pos] = true;
            ArrayList<Pair>list = new ArrayList<>();
            for(int child : arr[pos].children)
                if(!visited[child])
                    list.add(new Pair(child, cnt[child]));
            Collections.sort(list, (Pair a, Pair b) ->{
                // long aa = arr[a.pos].children.size(), bb = arr[b.pos].children.size();
                // if(a.cnt == b.cnt){
                    if(height[b.pos]== height[a.pos])
                        return Long.compare(a.pos, b.pos);
                    return Long.compare(height[b.pos], height[a.pos]);
                // }
                // return Long.compare(b.cnt, a.cnt);
            });
            // for(Pair  i : list)
            //     System.out.print((i.pos + 1) + " ");
            // System.out.println();
            x = x % mod;
            long ans = x;
            long curr = x;
            for(Pair p : list){
                ans = (ans + getAns(p.pos, curr)) % mod;
                // System.out.println((p.pos + 1) + " " + curr);
                curr  = (curr + x ) % mod;
                // curr += x;
                
            }
            return ans;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            long x = Integer.parseInt(t.nextToken());
            Tree tree = new Tree(n);

            for(int i = 0; i < n - 1; i ++){
                t = new StringTokenizer(r.readLine());
                int start = Integer.parseInt(t.nextToken());
                int end = Integer.parseInt(t.nextToken());
                if(start == end)
                    continue;
                tree.arr[start - 1].children.add(end - 1);
                tree.arr[end - 1].children.add(start - 1);
            }
            // System.out.println("~~~~~~~~~~~~~~~");
            tree.getCnt(0);
            tree.visited = new boolean[n];
            tree.getHeight(0, 1L);
            tree.visited = new boolean[n];
            // for(long i : tree.height)
            //     System.out.print(i + " ");
            // System.out.println();
            long ans = tree.getAns(0, x);
            System.out.println(ans);
        }
    }
    
}
