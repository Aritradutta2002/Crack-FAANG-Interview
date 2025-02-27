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
    Map dijkstras(Type from){
        Map<Type,Integer> available=new HashMap<>();
        available.put(from,0);
        visited.clear();
        Map<Type,Integer>shortestPath=new HashMap<>();
        while(!available.isEmpty()){
            Set<Type>keys=available.keySet();
            int min=Integer.MAX_VALUE;
            Type minData=null;
            for(Type key:keys){
                int current=available.get(key);
                if(current<min){
                    min=current;
                    minData=key;
                }
            }
            visited.add(minData);
            int currentWt=available.get(minData);
            shortestPath.put(minData,currentWt);
            available.remove(minData);
            List<edge>children=edges.get(minData);
            for(edge edge:children){
                if(!visited.contains(edge.data)){
                    if(available.containsKey(edge.data)&&available.get(edge.data)>edge.weight+currentWt){
                        available.replace(edge.data,edge.weight+currentWt);
                    }
                    else if(!available.containsKey(edge.data)){
                        available.put(edge.data,currentWt+edge.weight);
                    }
                }
            }

        }
    return shortestPath;
    }
}
public class Implementation {
    public static void main(String []args){
        graph<Character> g=new graph<Character>();
        g.addVertices('a');
        g.addVertices('b');
        g.addVertices('c');
        g.addVertices('d');
        g.addVertices('e');
        g.addEdges('a','b',6);
        g.addEdges('a','d',1);
        g.addEdges('d','b',2);
        g.addEdges('d','e',1);
        g.addEdges('b','e',2);
        g.addEdges('b','c',5);
        g.addEdges('e','c',5);
        Map<Character,Integer> path=g.dijkstras('a');
        Set <Character>vertices=path.keySet();
        for( char vertice:vertices){
            System.out.println(vertice+" "+path.get(vertice));
        }




    }
}
