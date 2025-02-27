import java.util.*;

class graph<Type>{
    private class edge {
        Type data;
        int weight;
        edge(Type data,int weight){
           this.data=data;
           this.weight=weight;
        }
    }
    
    //  We need to maintain a priority queue of all edges to improve time complexity
    //  You may sort list before converting into mst to trade time complexity for better space complexity.
    
    private class individualEdge{
        Type data1;
        Type data2;
        int weight;
        individualEdge(Type data1,Type data2,int weight){
            this.data1=data1;
            this.data2=data2;
            this.weight=weight;
        }
    }
    
    private List<Type> vertices=new ArrayList<>();
    private Map<Type,List<edge>>edges=new HashMap<>();
    private PriorityQueue<individualEdge>edgeList=new PriorityQueue<>(new Comparator<individualEdge>() {
        public int compare(individualEdge n1, individualEdge n2) {
            return Integer.compare(n1.weight,n2.weight);

        }
    });
    void addVertices(Type data){
        vertices.add(data);
        edges.put(data,new LinkedList<>());
    }
    void addEdges(Type data1,Type data2, int weight){
        edges.get(data1).add(new edge(data2,weight));
        edges.get(data2).add(new edge(data1,weight));
        edgeList.add(new individualEdge(data1,data2,weight));
    }
    private List <Type>visited=new ArrayList<>();
    void dfs(Type data){
        visited.clear();
        visited.add(data);
        dfsIterator(data);
        System.out.println();
    }
    private void dfsIterator(Type data){
        System.out.print(data+ " ");
        List <edge>children=edges.get(data);
        for (graph<Type>.edge edge : children) {
            Type child = edge.data;
            if (!visited.contains(child)) {
                visited.add(child);
                dfsIterator(child);
            }
        }
    }
    
    void kruskal(){
        set<Type>set=new set<>(vertices);
        Map<Type,List<edge>>newEdges=new HashMap<>();
        for(Type data:vertices){
            newEdges.put(data,new ArrayList<>());
        }
        while(!set.isComplete()){
            individualEdge minEdge=edgeList.remove();
            int pos1=set.getPos(minEdge.data1);
            int pos2=set.getPos(minEdge.data2);
            if(pos1!=pos2&&pos1!=Integer.MIN_VALUE&&pos2!=Integer.MIN_VALUE){
                set.union(pos1,pos2);
                newEdges.get(minEdge.data1).add(new edge(minEdge.data2,minEdge.weight));
                newEdges.get(minEdge.data2).add(new edge(minEdge.data1,minEdge.weight));
            }
        }
        edges=newEdges;
        for(Type i:vertices){
            for(edge j:edges.get(i)){
                System.out.println(i+" "+j.data +" "+j.weight);
            }
        }
    }


}
class set<Type>{
    private int size;
    private List<Set<Type>>list;
    set(List<Type>vertices){
        list=new ArrayList<>();
        size=vertices.size();
        for(Type i:vertices){
            Set<Type>set=new HashSet<>();
            set.add(i);
            list.add(set);
        }
    }
    int getPos(Type toFind){
        for(int i=0;i<list.size();i++){
            if(list.get(i).contains(toFind)){
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }
    void union(int pos1,int pos2){
        if(pos1>pos2){
            int temp=pos1;
            pos1=pos2;
            pos2=temp;
        }
        Set<Type>set=list.remove(pos2);
        list.get(pos1).addAll(set);
    }
    boolean isComplete(){
        return list.size()==1;
    }
}
public class Implementation {
    public static void main(String []args){
        graph<Integer> g=new graph<Integer>();
        g.addVertices(0);
        g.addVertices(1);
        g.addVertices(2);
        g.addVertices(3);
        g.addEdges(0,1,10);
        g.addEdges(1,3,15);
        g.addEdges(0,3,5);
        g.addEdges(2,0,6);
        g.addEdges(2,3,4);
        g.kruskal();
        g.dfs(0);

    }
}
