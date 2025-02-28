
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static boolean isInside(int x,int y,int size){
        return (x>0&&x<=size&&y>0&&y<=size);
    }
    public static class position{
        int x;
        int y;
        int move;
        position(int x,int y,int move){
            this.x=x;
            this.y=y;
            this.move=move;
        }
    }
	public static void main (String[] args)throws IOException {
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(r.readLine());
        for(int t=0;t<k;t++ ){
            boolean found=false;
            int size=Integer.parseInt(r.readLine());
            Queue<position>queue=new LinkedList<>();
            String[]current=(r.readLine()).split(" ");
            String[]target=(r.readLine()).split(" ");
            boolean samePos=true;
            if(current[0].equals(target[0])&&current[1].equals(target[1])){
                System.out.println("0");
                samePos=false;
                found=true;
            }
            queue.add(new position(Integer.parseInt(current[0]),Integer.parseInt(current[1]),0));
            int minMoves=1;
            List<Integer>visited=new ArrayList<>();
            int []pos={-1,-2,1,-2,2,1,2,-1,1,2,-1,2,-2,1,-2,-1};
            while(!queue.isEmpty()&&samePos){
                position currentPos=queue.remove();
                int posX=currentPos.x;
                int posY=currentPos.y;
                for(int i=0;i<pos.length;i=i+2){
                    int newX=posX+pos[i];
                    int newY=posY+pos[i+1];
                    if(newX==Integer.parseInt(target[0])&&newY==Integer.parseInt(target[1])){
                        System.out.println(currentPos.move+1);
                        queue.clear();
                        found=true;
                        break;
                    }
                    if(isInside(newX,newY,size)){
                        String s1=Integer.toString(newX);
                        s1=s1+Integer.toString(newY);
                        if(!visited.contains(Integer.parseInt(s1))){
                            visited.add(Integer.parseInt(s1));
                            queue.add(new position(newX,newY,currentPos.move+1));
                        }
                    }

                }
            }
            if(!found){
                System.out.println("-1");
            }
        }
	}
}
