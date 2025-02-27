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
    void dfs(Type data){
        visited.clear();
        visited.add(data);
        dfsIterator(data);
        System.out.println();
    }
    private void dfsIterator(Type data){
        System.out.print(data+ " ");
        List <edge>children=edges.get(data);
        for(int i=0;i<children.size();i++){
            Type child= children.get(i).data;
            if(!visited.contains(child)){
                visited.add(child);
                dfsIterator(child);
            }
        }
    }
    void bfs(Type data){
        Queue<Type>queue=new LinkedList<>();
        visited.clear();
        queue.add(data);
        visited.add(data);
        while(!queue.isEmpty()){
            Type num=queue.remove();
            System.out.print(num+" ");
            List<edge>children=edges.get(num);
            for(int i=0;i<children.size();i++){
                Type child=children.get(i).data;
                if(!visited.contains(child)){
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
        System.out.println();

    }
}
public class Implementation {
    public static void main(String []args){
        graph<Integer> g=new graph<Integer>();
        g.addVertices(1);
        g.addVertices(2);
        g.addVertices(3);
        g.addVertices(4);
        g.addVertices(5);
        g.addEdges(1,2,0);
        g.addEdges(2,3,0);
        g.addEdges(3,4,0);
        g.addEdges(4,1,0);
        g.addEdges(3,1,0);
        g.addEdges(3,5,0);
        g.addEdges(4,5,0);
        g.dfs(5);
        g.bfs(5);
    }
}
