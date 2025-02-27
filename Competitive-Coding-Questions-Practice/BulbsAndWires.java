import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
 class BulbsAndWires {
     static int getMin(ArrayList<Integer>list,ArrayList<Integer>ends,int sum,int k){
        int listPtr=list.size()-1;
        int endPtr=ends.size()-1;
        while(listPtr>=0&&endPtr>=0&&k>1){
            if((float)list.get(listPtr)/2.0>=(float)ends.get(endPtr)){
                sum-=list.get(listPtr);
                listPtr--;
                k-=2;
            }
            else{
                sum-=ends.get(endPtr);
                endPtr--;
                k--;
            }
        }
        while(listPtr>=0&&k>1){
            sum-=list.get(listPtr);
            listPtr--;
            k-=2;
        }
        while(endPtr>=0&&k>0){
            sum-=ends.get(endPtr);
            endPtr--;
            k--;
        }
        return sum;
     }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int n=Integer.parseInt(data[0]);
            int k=Integer.parseInt(data[1]);
            String s=r.readLine().trim();
            ArrayList<Integer>list=new ArrayList<>();
            ArrayList<Integer>ends=new ArrayList<>();
            int count=0;
            boolean start=true;
            if(s.charAt(0)=='1')
                start=false;
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                // System.out.println(i+" "+count);
                if(c=='1'&&count!=0){
                    if(start){
                        start=false;
                        ends.add(count);
                    }
                    else{
                        list.add(count);
                    }

                    count=0;
                }
                else if(c=='0')
                    count++;
            }
            //0001100100
            
            if(count!=0)
                ends.add(count);
            // System.out.println(list);
            // System.out.println(ends);
            Collections.sort(list);
            Collections.sort(ends);
            
            int sum=0;
            for(int i:list)
                sum+=i;
            for(int i:ends)
                sum+=i;
            int min=Integer.MAX_VALUE;
            while(true){
                min =Math.min(min, getMin(list, ends, sum, k));
                if(ends.isEmpty())
                    break;
                ends.remove(0);
            }
            System.out.println(min);
            
        }
    } 
}
//0111011110
