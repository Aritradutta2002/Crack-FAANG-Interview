import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/* 
https://www.codechef.com/problems/ASHIGIFT
Binary Search
*/
class Clan {
    long minMembers;
    long size;
    Clan(long minMembers,long size){
        this.minMembers=minMembers;
        this.size=size;
    }
}

class Gift{
    static boolean isValid(HashMap<Long,Clan>clans,HashMap<Long,Long>dishes,long distance,long members,ArrayList<Long>pos){
        for(long i:pos){
            if(clans.containsKey(i)){
                Clan clan=clans.get(i);
                if(members>=clan.minMembers){
                    members+=clan.size;
                }
            }
            if(dishes.containsKey(i)){
                members-=dishes.get(i);
            }
    
        }
        return members>=1;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int l=Integer.parseInt(r.readLine());
        while(l-->0){
            long distance=Long.parseLong(r.readLine());
            String []data1=r.readLine().split(" ");
            String []data2=r.readLine().split(" ");
            HashMap<Long,Clan> clans=new HashMap<Long,Clan>();
            HashMap<Long,Long> dishes=new HashMap<Long,Long>();
            ArrayList<Long>pos=new ArrayList<>();
            if(!data1[0].equals("0")){
                for(int i=1;i<data1.length;i+=2){
                    pos.add(Long.parseLong(data1[i]));
                    dishes.put(Long.parseLong(data1[i]), Long.parseLong(data1[i+1]));
                }
            }
            if(!data2[0].equals("0")){
                for (int i=1;i<data2.length;i+=3){
                    pos.add(Long.parseLong(data2[i]));
                    clans.put(Long.parseLong(data2[i]),new Clan(Long.parseLong(data2[i+1]),Long.parseLong(data2[i+2])));
                }
            }
            Collections.sort(pos);;
            long ans =-1;
            long min=0;
            long max=Long.MAX_VALUE;
            while(min<=max){
                long mid=min+(max-min)/2;
                if(isValid(clans, dishes, distance, mid,pos)){
                    ans=mid;
                    max=mid-1;
                }
                else
                    min=mid+1;

            }
            System.out.println(ans);

        }

}

}