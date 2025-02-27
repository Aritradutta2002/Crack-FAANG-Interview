import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
class player{
    int ratings;
    int pos;
    player(int ratings,int pos){
        this.ratings=ratings;
        this.pos=pos;
    }
}
class comp implements Comparator<player>{

    @Override
    public int compare(player o1, player o2) {
        return Integer.compare(o2.ratings, o1.ratings);
    }

}
 class RatingsAndRankings {
    static int[]getRank(player[]players,int n){
        int[]ranks=new int[n];
        int last=1;
        ranks[0]=last;
        for(int i=1;i<n;i++){
            if(players[i].ratings==players[i-1].ratings)
                ranks[i]=ranks[i-1];
            else
                ranks[i]=last+1;
            last++;
        }
        return ranks;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data1=r.readLine().split(" ");
            int n=Integer.parseInt(data1[0]);
            int m=Integer.parseInt(data1[1]);
            player[]players=new player[n];
            String[]data=r.readLine().split(" ");
            for(int i=0;i<n;i++){
                players[i]=new player(Integer.parseInt(data[i]), i);
            }
            int[][]changes=new int[n][m];
            for(int i=0;i<n;i++){
                String[]d=r.readLine().split(" ");
                for(int j=0;j<m;j++)
                    changes[i][j]=Integer.parseInt(d[j]);
            }
            int[]ratingsMax=new int[n];
            int[]ratingsPos=new int[n];
            int[]rankMin=new int[n];
            int[]rankPos=new int[n];
            Arrays.fill(rankMin, Integer.MAX_VALUE);
            Arrays.sort(players,new comp());
            int[]z=getRank(players, n);
            for(int i=0;i<n;i++){
                if(z[i]<rankMin[players[i].pos]){
                    rankMin[players[i].pos]=z[i];
                    rankPos[players[i].pos]=-1;
                }
            }
            for(player p:players){
                if(p.ratings>ratingsMax[p.pos]){
                    ratingsMax[p.pos]=p.ratings;
                    ratingsPos[p.pos]=-1;
                }
            }
            for(int month=0;month<m;month++){
                for(int i=0;i<n;i++)
                    players[i].ratings+=changes[players[i].pos][month];
                Arrays.sort(players, new comp());
                for(player p:players){
                    if(p.ratings>ratingsMax[p.pos]){
                        ratingsMax[p.pos]=p.ratings;
                        ratingsPos[p.pos]=month;
                    }
                }
                int[]ranks=getRank(players, n);
                for(int i=0;i<n;i++){
                    if(ranks[i]<rankMin[players[i].pos]){
                        rankMin[players[i].pos]=ranks[i];
                        rankPos[players[i].pos]=month;
                    }
                }
            }
            int count=0;
            for(int i=0;i<n;i++)
                if(rankPos[i]!=ratingsPos[i])
                    count++;
            System.out.println(count);

        }
    }     
}