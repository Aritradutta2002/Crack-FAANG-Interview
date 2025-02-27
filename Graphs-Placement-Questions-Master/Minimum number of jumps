import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//*********************************DP APPROACH******************************************************

public class Implementation {
    static int minSteps(int pos,String[]array,int[]memory){
        if(pos>=array.length-1){
            return 0;
        }
        else{
            if(memory[pos]!=0){
                return memory[pos];
            }
            else{

                int min=Integer.MAX_VALUE;
                int current=Integer.parseInt(array[pos]);
                for(int i=1;i<=current;i++){
                    int num=minSteps(pos+i,array,memory);
                    if(num<min){
                        min=num;
                    }
                }
                if(min!=Integer.MAX_VALUE){
                    min++;

                }
                memory[pos]=min;
                return min;

            }
        }
    }
    public static void main(String[]args) throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(r.readLine());
        for(int t=0;t<k;t++){
            int size=Integer.parseInt(r.readLine());
            String[]data=(r.readLine()).split(" ");
            int[]memory=new int[size];
            int min=minSteps(0,data,memory);
            if(min==Integer.MAX_VALUE){
                System.out.println("-1");
            }
            else{
                System.out.println(min);
            }
        }
    }
}
