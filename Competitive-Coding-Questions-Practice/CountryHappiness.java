import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CountryHappiness {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            // System.out.println(t);
            String[]data=r.readLine().split(" ");
            int size=Integer.parseInt(data[0]);
            String[]populationStrings=r.readLine().split(" ");
            String[]predictionStrings=r.readLine().split(" ");
            int[]population=new int[size];
            int[]prediction=new int[size];
            for(int i=0;i<size;i++){
                population[i]=Integer.parseInt(populationStrings[i]);
                prediction[i]=Integer.parseInt(predictionStrings[i]);
            }   
            Tree tree=new Tree(size, population, prediction);         
            for(int i=0;i<size-1;i++){
                String[]d=r.readLine().split(" ");
                tree.add(Integer.parseInt(d[0])-1, Integer.parseInt(d[1])-1);
            }
            if(tree.check(tree.nodes[0])[0]==-1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
class Node {
    int data;
    ArrayList<Integer> children;

    Node(int data) {
        children = new ArrayList<>();
        this.data = data;
    }
}

class Tree {
    Node[] nodes;
    int[] population;
    int[] prediction;

    Tree(int size, int[] population, int[] prediction) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
        this.prediction = prediction;
        this.population = population;
    }

    void add(int pos1, int pos2) {
        nodes[pos1].children.add(pos2);
    }

    long[] isPossible(long population,long positive,long negeative, long prediction) {
        positive+=negeative;
        positive+=population;
        negeative=0;
        long mod=Math.abs(prediction);
        if(mod<=positive&&positive%2==mod%2){
            long n2=positive/2;
            long n1=positive-n2;
            n1+=mod/2;
            n2-=mod/2;
            if(prediction>0){
                positive=n1;
                negeative=n2;
            }
            else if(prediction<0){
                negeative=n1;
                positive=n2;
            }
            long[]s={positive,negeative};
            return s;

        }
        else{
                long[]s={-1L,-1L};
                return s;
        }
    }

    long[] check(Node n) {
        long[]ret=new long[2];
        int pos=0;
        int neg=0;
        long maxNeg=0;
        for (int child : n.children) {
            long []result = check(nodes[child]);
            if (result[0] == -1){
                ret[0]=-1;
                ret[1]=-1;
                return ret;
            }
            pos+=result[0];
            neg+=result[1];
            maxNeg+=(result[0]-population[child]);
        }
        long[]result=isPossible(population[n.data],pos,neg,prediction[n.data]);
        // System.out.println();
        if(result[1]<maxNeg){
            ret[0]=-1;
            ret[1]=-1;
            return ret;
        }
        if (result[0]!=-1){
            ret[0]=result[0];
            ret[1]=result[1];
            return ret;
        }
        else{
            ret[0]=-1;
            ret[1]=-1;
            return ret;
        }
    }

}
