import java.util.ArrayList;
import java.util.List;

//*********************************BACKTRACKING APPROACH*************************************************

class nQueenProblem{
    public static  void Solution(int n){
        List<List<Integer>>list=iterator(new int[n][n],0,new ArrayList<>());
        if(list.isEmpty()){
            System.out.println(-1);
        }
        else {
            for (List<Integer> l : list) {
                for (Integer i : l) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
    private static boolean isValid(int[][]visited,int x,int y){
        return x>=0&&x<visited.length&&y>=0&&y<visited.length;
    }
    private static int[][]visit(int[][]oldVisited,int x,int y){
        int[][]visited=new int[oldVisited.length][oldVisited.length];
        for(int i=0;i<visited.length;i++){
            System.arraycopy(oldVisited[i], 0, visited[i], 0, visited.length);
        }
        int i=x;
        int j=y;
        while (isValid(visited,i,j)){
            visited[i][j]=1;
            i++;j++;
        }
        i=x;
        j=y;
        while (isValid(visited,i,j)){
            visited[i][j]=1;
            i++;j--;
        }
        i=x;
        j=y;
        while (isValid(visited,i,j)){
            visited[i][j]=1;
            i++;
        }
        return visited;

    }
    private static List<List<Integer>> iterator(int[][]visited,int x,List<Integer>pos){
        List <List<Integer>>newList=new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            if(visited[x][i]==0){
                if(x==visited.length-1){
                    List<Integer> temp = new ArrayList<>(pos);
                    temp.add(i+1);
                    newList.add(temp);
                }
                else{
                    List<Integer> temp = new ArrayList<>(pos);
                    temp.add(i+1);
                    List<List<Integer>> list=iterator(visit(visited,x,i),x+1,temp);
                    newList.addAll(list);
                }
            }
        }
        return newList;
    }
}

public class Implementation {
    public static void main(String[]args) {
        nQueenProblem.Solution(4);
    }
}
