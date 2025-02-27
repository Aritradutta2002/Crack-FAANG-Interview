import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class ScalarProduct {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int q = Integer.parseInt(t.nextToken());
        long weights[] = new long[n];
        t = new StringTokenizer(r.readLine());
        for(int i=0;i<n;i++)
            weights[i] = Long.parseLong(t.nextToken());
        mTree tree = new mTree(n,weights);
        for(int i = 0; i <n-1 ; i++){
            t = new StringTokenizer(r.readLine());
            int pos1 = Integer.parseInt(t.nextToken())-1;
            int pos2 = Integer.parseInt(t.nextToken())-1;
            tree.add(pos1, pos2);
        }
        
        tree.dfs(tree.map[0] , 0);
        // System.out.println();
        while(q-->0){
            t = new StringTokenizer(r.readLine());
            int pos1 = Integer.parseInt(t.nextToken())-1;
            int pos2 = Integer.parseInt(t.nextToken())-1;
            System.out.println(tree.getCount(pos1, pos2));
        }
         
    } 
}
class mNode{
    mNode parent;
    int index;
    long weight, squareTop;
    ArrayList<mNode>children;

    mNode(){
        children = new ArrayList<>();
        parent = null;
        index = 0;
        weight = 0;
        squareTop = 0;
    }
}
class mTree{
    mNode root;
    mNode[]map;
    long N = (long)Math.pow(2, 32);

    mTree(int n,long[]weights){
        map = new mNode[n];
        for(int i = 0; i < n; i++){
            map[i] = new mNode();
            map[i].index = i;
            map[i].weight = weights[i];
        }
    }

    void add(int pos1, int pos2){
        map[pos1].children.add(map[pos2]);
        map[pos2].parent = map[pos1];
    }

    void dfs(mNode n , long sum){
        sum = (sum + ((long)Math.pow(n.weight%N, 2)) % N) % N;
        n.squareTop = sum;
        for(mNode child:n.children)
            dfs(child , sum);
    }


    long getCount(int pos1, int pos2){
        mNode n1 = map[pos1];
        mNode n2 = map[pos2];
        long ans = 0;
        while(n1!=null && n2!=null){
            // System.out.println(n1.index+" "+n2.index);
            if(n1.index ==n2.index){
                ans = (ans + n1.squareTop) % N;
                break;
            }
            long w1 = n1.weight % N;
            long w2 = n2.weight % N;
            w1 = (w1 * w2) % N;
            ans = (ans + w1) % N;
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return ans;
    }

}
