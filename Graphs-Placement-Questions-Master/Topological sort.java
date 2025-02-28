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
    }
    private List <Type>visited=new ArrayList<>();
    
    List<Type>order;
    List<Type> topoSort() {
        order=new ArrayList<>();
        visited.clear();

        for(int i=0;i<vertices.size();i++){
            int pos=Integer.MAX_VALUE;
            if(!visited.contains(vertices.get(i))){
                List<edge>children=edges.get(vertices.get(i));
                for(int j=children.size()-1;j>=0;j--){
                    edge child=children.get(j);
                    if(visited.contains(child.data)){
                        int cPos=order.indexOf(child.data);
                        if(cPos<pos){
                            pos=cPos;
                        }
                    }
                }
                if(pos==Integer.MAX_VALUE){
                    traverser(vertices.get(i),false,0);
                }
                else{
                    traverser(vertices.get(i),true,pos);
                }

            }
        }
        return order;

    }
    void traverser(Type data,boolean between,int pos){
        visited.add(data);
        if(between){
            order.add(pos,data);
        }
        else{
            order.add(data);
        }
        List<edge>children=edges.get(data);
        for(edge i:children){
            edge child=i;
            if(!visited.contains(child.data)&&!between){
                traverser(child.data, false,pos);
            }
            else if(!visited.contains(child.data)&&between){
                traverser(child.data, true,pos+1);
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
        
        g.addEdges(5,0,0);
        g.addEdges(5,2,0);
        g.addEdges(2,3,0);
        g.addEdges(4,0,0);
        g.addEdges(4,1,0);
        g.addEdges(1,3,0);

        List<Integer>l=g.topoSort();
        for(int i:l){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
