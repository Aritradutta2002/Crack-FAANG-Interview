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

    class storage{
        private Type data;
        private int distance;
        private List<Type> list;
        storage(Type data,int distance){
            this.data=data;
            this.distance=distance;
            list=new ArrayList<>();
        }
        storage(Type data,List<Type>list,int distance){
            this.data=data;
            this.list=list;
            this.distance=distance;
        }
    }
    void shortestPath(Type from,Type to){
        List<Type>addList=new ArrayList<>();
        addList.add(from);
        storage s=new storage(from,addList,0);
        visited.clear();
        Queue<storage> queue=new LinkedList<>();
        queue.add(s);
        visited.add(from);
        List <storage> list=new ArrayList<>();
        while(!queue.isEmpty()){
            storage poped=queue.remove();
//            System.out.println(poped.data);
            if(poped.data==to){
                System.out.println(poped.distance);
                for(int i=0;i<poped.list.size();i++){
                    System.out.print(poped.list.get(i)+" ");
                }
                System.out.println();
            }
            List<edge>children=edges.get(poped.data);
            for(int i=0;i<children.size();i++   ){
                if(!visited.contains(children.get(i).data)){
                    List<Type> mlist=new LinkedList<>();
                    for(int j=0;j<poped.list.size();j++){
                        mlist.add(poped.list.get(j));
                    }
                    mlist.add(children.get(i).data);
                    visited.add(children.get(i).data);
                    queue.add(new storage(children.get(i).data,mlist,poped.distance+1));
                }
            }
        }

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
        g.addVertices(5);
        g.addVertices(6);
        g.addVertices(7);
        g.addEdges(2,1,0);
        g.addEdges(1,0,0);
        g.addEdges(0,3,0);
        g.addEdges(3,4,0);
        g.addEdges(3,7,0);
        g.addEdges(4,7,0);
        g.addEdges(7,6,0);
        g.addEdges(4,6,0);
        g.addEdges(4,5,0);
        g.addEdges(5,6,0);
        g.shortestPath(0,7);



    }
}
