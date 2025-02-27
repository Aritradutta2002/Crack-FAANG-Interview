import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class AnotherTreeWithNumberTheory {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());
        mTree1 tree = new mTree1(n);
        for(int i = 1; i < n; i ++){
            int m = Integer.parseInt(t.nextToken());
            tree.add(m - 1, i);
        }

        tree.ch(tree.nodes[0]);

        int q = Integer.parseInt(r.readLine());

        while(q -- > 0){
            t = new StringTokenizer(r.readLine());
            int pos = Integer.parseInt(t.nextToken()) - 1;
            long num = Integer.parseInt(t.nextToken());
            System.out.println(tree.getSum(tree.nodes[pos], num));
        }
    }
        
}

class mNode123 {
    ArrayList<mNode123>children = new ArrayList<>();
    int size = 0;
}

class mTree1 {
    
    mNode123[]nodes;
    
    mTree1(int n){
        nodes = new mNode123[n];
        for(int i = 0; i < n; i ++)
            nodes[i] = new mNode123();
    }

    void add(int n, int m){
        nodes[n].children.add(nodes[m]);
        nodes[n].size++;
    }

    void ch(mNode123 n){
        while(n.size == 1){
            n.size = n.children.get(0).size;
            n.children = n.children.get(0).children;
        }
        for(mNode123 child : n.children)
            ch(child);
    }

    long getSum(mNode123 n, long num){

        if(n.size == 0)
            return 0;

        if(num % n.size != 0)
            return num;
        
        long s = 0;
        for(mNode123 child : n.children)
            s += getSum(child, num / n.size);

        return s;
    }

}