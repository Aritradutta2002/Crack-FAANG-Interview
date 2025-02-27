import java.util.*;

//******************************************DFS APPROACH**************************************************

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
    void bridge(){
        visited.clear();
        List<List<Type>> finList=traverser(vertices.get(0)).list;
        for(List<Type>ll:finList){
            for(Type t:ll){
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
    class returnType{
        List<List<Type>> list;
        boolean v;
        returnType(List<List<Type>> list,boolean v){
            this.list=list;
            this.v=v;
        }
    }
    private returnType traverser(Type data){
        visited.add(data);
        List<edge>children=edges.get(data);
        if(children.size()==1&&visited.contains(children.get(0).data)){
            List<Type>newList=new ArrayList<>();
            newList.add(data);
            List<List<Type>>finList=new ArrayList<>();
            finList.add(newList);
            return  new returnType(finList,true);
        }

        List<List<Type>>finList=new ArrayList<>();
        boolean b=false;
        for (edge child:children){
            if(!visited.contains(child.data)){
                returnType r=traverser(child.data);
                List<List<Type>>list=r.list;
                if(r.v&&children.size()==2){
                    list.get(0).add(data);
                    b=true;
                }
                finList.addAll(list);
            }
        }

        return new returnType(finList,b);
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
        g.addEdges(0,2,0);
        g.addEdges(0,1,0);
        g.addEdges(1,2,0);
        g.addEdges(1,6,0);
        g.addEdges(1,3,0);
        g.addEdges(3,5,0);
        g.addEdges(1,4,0);
        g.addEdges(4,5,0);
        g.bridge();

    }
}
