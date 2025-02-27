import java.util.ArrayList;
import java.util.Scanner;

//**************************DFS APROACH************************************************


public class Implementation {
    static boolean contains(int x,int y,int N,int M){
        return(x>=0&&x<N&&y>=0&&y<M);
    }
    static void dfs(int x,int y,ArrayList<ArrayList<Integer>> list,int N,int M){
        int []array={0,1,1,0,1,1,-1,0,0,-1,-1,-1,1,-1,-1,1};
        for(int i=0;i<array.length;i=i+2){
            int newx=x+array[i];
            int newy=y+array[i+1];
            if(contains(newx,newy,N,M)){
                if(list.get(newx).get(newy)==1){

                    if(visited[newx][newy]==0){
                        visited[newx][newy]=1;
                        dfs(newx,newy,list,N,M);}
                }
            }
        }
    }
    static int[][]visited;
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
        visited=new int[N][M];
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j]==0&&list.get(i).get(j)==1){
                    visited[i][j]=1;
                    dfs(i,j,list,N,M);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int N=sc.nextInt();
        int M=sc.nextInt();
        for(int i=0;i<N;i++){
            list.add(new ArrayList<>());
            for(int j=0;j<M;j++){
                list.get(i).add(sc.nextInt());
            }
        }
        System.out.println(findIslands(list,N,M));

    }
}
