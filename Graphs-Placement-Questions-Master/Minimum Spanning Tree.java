class MST
{   
    static class Comp implements Comparator<int[]> {
        @Override
        public int compare(int[] i, int[] j) {
            if(i[0]>j[0]){
                return 1;
            }
            else if(i[0]==j[0]){
                return 0;
            }
            else{
                return -1;
            }
        }
    }
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph)
    {
        PriorityQueue<int[]> available = new PriorityQueue<>(new Comp());
        int[]visited=new int[V];
        int visitedCount=0;
        visited[0]=1;
        visitedCount++;
        for(int i=0;i<graph.get(0).size();i++){
            if(graph.get(0).get(i)!=Integer.MAX_VALUE){
                int []f={graph.get(0).get(i),0,i};
                available.add(f);
            }
        }
        int sum=0;
        while(visitedCount<V){
            int[]edge=available.remove();
            // System.out.println(edge[1]+" "+edge[2]);
            while(visited[edge[2]]==1){
                edge=available.remove();
            }
            sum+=edge[0];
            visited[edge[2]]=1;
            for(int i=0;i<graph.get(edge[2]).size();i++){
                if(graph.get(edge[2]).get(i)!=Integer.MAX_VALUE){
                    int []f={graph.get(edge[2]).get(i),edge[2],i};
                    available.add(f);
                }
            }
            visitedCount++;
        }
        return sum;
    }
}

