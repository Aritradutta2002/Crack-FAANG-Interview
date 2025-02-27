import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
class RootTheTree {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            e tree=new e(n);
            for(int i=0;i<n-1;i++){
                String[]data=r.readLine().split(" ");
                int pos1=Integer.parseInt(data[0])-1;
                int pos2=Integer.parseInt(data[1])-1;
                tree.add(pos1, pos2);
            }
            System.out.println(tree.getCount());
        }
         
    } 
}
class e{
    int n;
    ArrayList<ArrayList<Integer>>edges;
    boolean[]visited;
    boolean []visitedMain;
    e(int n){
        this.n=n;
        edges=new ArrayList<>();
        for(int i=0;i<n;i++) {
            edges.add(new ArrayList<>());
        }
        visitedMain=new boolean[n];
        visited=new boolean[n];
    }
    void add(int pos1,int pos2){
        edges.get(pos1).add(pos2);
    }
    int count=0;
    int getCount(){
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visitedMain[i]=true;
                traverseUtil(i);
                count++;
            }
        }
        return count-1;
    }
    private void traverseUtil(int pos){
        visited[pos]=true;
        for(Integer edge:edges.get(pos)){
            if(visitedMain[edge]){
                visitedMain[edge]=false;
                count--;
            }
            else if(!visited[edge])
                traverseUtil(edge);

        }
    }
}
