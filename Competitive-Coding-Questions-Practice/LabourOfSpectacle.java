import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class LabourOfSpectacle {
    static class Node{
        Node(int pos,int weight){
            this.weight = weight;
            this.pos = pos;
        }
        int pos;
        int weight;
        ArrayList<Node>children = new ArrayList<>();
    }
    static class Tree{
        Node[]list;
        long sum = 0;
        boolean[]visited;
        ArrayList<Integer>extra = new ArrayList<>();
        Tree(int n, int[]weights){
            list = new Node[n];
            for(int i = 0; i < n; i ++)
                list[i] = new Node(i,weights[i]);
            visited = new boolean[n];
        }

        void add(int p1, int p2){
            list[p1].children.add(list[p2]);
            list[p2].children.add(list[p1]);
        }
        void calculate(Node n){
            visited[n.pos] = true;
            sum += n.weight;
            int s = n.children.size();
            for(int i = 0; i < s - 1; i ++)
                extra.add(n.weight);
            for(Node child : n.children)
                if(!visited[child.pos])
                    calculate(child);
        }


        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]weight = new int[n];
            for(int i = 0; i < n; i++)
                weight[i] = Integer.parseInt(t.nextToken());
            Tree tree = new Tree(n, weight);
            
            for(int i = 0; i < n - 1; i++){
                t = new StringTokenizer(r.readLine());
                int p1 = Integer.parseInt(t.nextToken()) - 1;
                int p2 = Integer.parseInt(t.nextToken()) - 1;
                tree.add(p1, p2);
            }
            for(Node child : tree.list)
                if(!tree.visited[child.pos])
                    tree.calculate(child);
            // System.out.println(tree.extra);
            StringBuilder b = new StringBuilder();
            Collections.sort(tree.extra, Collections.reverseOrder());
            int ptr = 0;
            // System.out.println(tree.extra);
            int ss = tree.extra.size();
            for(int i = 0; i < n - 1;i++){
                b.append(tree.sum);
                b.append(" ");
                if(ptr < ss)
                    tree.sum += tree.extra.get(ptr++);
            }
            // System.out.println(tree.list[3].weight);
            System.out.println(b);
        }        
    }
        
}
