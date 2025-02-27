import java.util.*;

class graph<Type>{
    private class edge{
        Type data;
        int weight;
        edge(Type data,int weight){
           this.data=data;
           this.weight=weight;
        }
    }
    private List<Type> vertices=new ArrayList<>();
    private Map<Type,List<edge>>edges=new HashMap<>();
    void addVertices(Type data){
        vertices.add(data);
        edges.put(data,new LinkedList<>());
    }
    void addEdges(Type data1,Type data2, int weight){
        edges.get(data1).add(new edge(data2,weight));
        edges.get(data2).add(new edge(data1,weight));
    }
    private List <Type>visited=new ArrayList<>();
    
    boolean isCyclic(){
        visited.clear();
        for(int i=0;i<vertices.size();i++){
            if(!visited.contains(vertices.get(i))){
                if(isCyclicIterator(vertices.get(i),null)){
                    return true;
                }
            }
        }
        //This Loop is to check for multiple edges between two vertices    a<---->b
        //                                                                 b<---->a   
        for(int i=0;i<vertices.size();i++){
            if(!check(edges.get(vertices.get(i)))){
                return true;
            }
        }
        return false;

    }
    boolean check(List<edge> li){
        List<edge> l=li;
        Set<edge> set = new HashSet<>();
        for(int i=0;i<l.size();i++){
            set.add(l.get(i));
        }
        if(set.size()==l.size()){
            return true;
        }
        else{
            return false;
        }

    }
    private boolean isCyclicIterator(Type data,Type parent){
        List <edge>children=edges.get(data);
        visited.add(data);
        for(int i=0;i<children.size();i++){
            Type child= children.get(i).data;
            if(!visited.contains(child)){
                if(isCyclicIterator(child,data)){
                    return true;
                }
            }
            else{
                if(child==data){
                    return true;
                }
                if((child != parent) && (parent != null)){
                    return true;
                }
            }
        }
        return false;
    }
}
public class Implementation {
    public static void main(String []args){
        graph<Integer> g=new graph<Integer>();
        g.addVertices(0);
        g.addVertices(1);
        g.addVertices(2);
        g.addVertices(3);
        g.addVertices(4);
        g.addEdges(0,1,0);
        g.addEdges(2,1,0);
        g.addEdges(1,2,0);
        g.addEdges(3,2,0);
        g.addEdges(4,2,0);
        g.addEdges(3,1,0);
        g.addEdges(3,5,0);
        g.addEdges(4,5,0);
        System.out.println(g.isCyclic());


    }
}
