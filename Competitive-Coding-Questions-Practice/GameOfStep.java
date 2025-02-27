import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class GameOfStep {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int[]cont=new int[n];
            int count=0;
            int ptr=0;
            for(int i=0;i<n;i++){
                if(array[i]==0)
                    count++;
                else if(count!=0){
                    cont[ptr]=count;
                    count=0;
                    ptr++;
                }
            }
            if(count!=0)
                cont[ptr]=count;
            int max=Integer.MIN_VALUE;
            int pos=0;
            for(int i=0;i<n;i++)
                if(cont[i]>max){
                    pos=i;
                    max=cont[i];
                }
            cont[pos]=Integer.MIN_VALUE;
            count=0;
            int wanted=max/2;
            if(max%2==1)
                wanted++;
            boolean multiple=false;
            for(int i:cont){
                if(i>=wanted){
                    multiple=true;
                    break;
                }
            }
            if(max==0)
                System.out.println("No");
            else if(max%2==0||max==1){
                if(max%2==0)
                    System.out.println("No");
                else
                    if(!multiple)
                        System.out.println("Yes");
                    else
                        System.out.println("No");
            }
            else if(multiple)
                System.out.println("No");

            else{
                System.out.println("Yes");
            }
               
        } 
    } 
}