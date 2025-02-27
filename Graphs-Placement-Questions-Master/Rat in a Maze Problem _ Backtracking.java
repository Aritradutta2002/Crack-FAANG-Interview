
import java.util.ArrayList;

//********************************BACKTRACKING APPROACH********************************

class RatProblem {
    private static ArrayList<String>paths;
    public static ArrayList<String> printPath(int[][] m, int n) {
        paths=new ArrayList<>();
        //If starting point itself is 0
        if(m[0][0]==0){
            return paths;
        }
        traverser(m,0,0,"",new int[n][n]);
        return paths;

    }
    private static boolean isValid(int x,int y,int[][]matrix){
        return x>=0&&y>=0&&y<matrix.length&&x<matrix.length;
    }
    private static void traverser(int[][]matrix,int x,int y,String s,int[][]visited){
        visited[x][y]=1;
        if(x==matrix.length-1&&y==matrix.length-1){
            paths.add(s);
        }
        int[]pos={1,0,0,-1,0,1,-1,0};
        for(int i=0;i<pos.length;i=i+2){
            int newx=x+pos[i];
            int newy=y+pos[i+1];
            if(isValid(newx,newy,matrix)){
                if(matrix[newx][newy]==1&&visited[newx][newy]==0){
                    String t="";
                    t=t+s;
                    if(pos[i]==1&&pos[i+1]==0){
                        t=t+"D";
                    }
                    if(pos[i]==-1&&pos[i+1]==0){
                        t=t+"U";
                    }
                    if(pos[i]==0&&pos[i+1]==1){
                        t=t+"R";
                    }
                    if(pos[i]==0&&pos[i+1]==-1){
                        t=t+"L";
                    }


                    int[][]newv=new int[visited.length][visited.length];
                    for(int l=0;l<visited.length;l++){
                        for(int j=0;j<visited.length;j++){
                            newv[l][j]=visited[l][j];
                        }
                    }
                    traverser(matrix,newx,newy,t,newv);
                }
            }
        }
    }
}
public class Implementation {

    public static void main(String[]args) {
        int [][]i={{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        ArrayList<String>s= RatProblem.printPath(i,4);
        if (s.size()==0){
            System.out.println(-1);
        }
        else{
            for(String l :s){
                System.out.println(l);
            }
        }
    }
}
