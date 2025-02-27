import java.util.ArrayList;


class Graph{
    ArrayList<ArrayList<Integer>>list=new ArrayList<>();
    ArrayList<ArrayList<Integer>>undirected=new ArrayList<>();
    Graph(int vertices){
        for(int i=0;i<vertices;i++){
            list.add(new ArrayList<Integer>());
            undirected.add(new ArrayList<Integer>());
        }
    }
    void addEdge(int pos1,int pos2){
        list.get(pos1-1).add(pos2-1);
    }
    void addUndirected(int pos1,int pos2){
        list.get(pos1-1).add(pos2-1);
        list.get(pos2-1).add(pos1-1);
        undirected.get(pos1-1).add(pos2-1);
    }
    
    

}
public class DirectingEdges {
    
}