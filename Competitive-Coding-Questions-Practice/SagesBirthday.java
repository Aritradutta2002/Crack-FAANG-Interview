import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SagesBirthday {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        StringTokenizer t=new StringTokenizer(r.readLine());
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(t.nextToken());
        Arrays.sort(array);
        int[]newArray=new int[n];
        int ptr=0;
        for(int i=1;i<n;i+=2){
            newArray[i]=array[ptr];
            ptr++;
        }
        for(int i=0;i<n;i+=2){
            newArray[i]=array[ptr];
            ptr++;
        }
        int count1=0;
        for(int i=1;i<n-1;i++)
            if(newArray[i]<newArray[i+1]&&newArray[i]<newArray[i-1])
                count1++;
        if(n%2==0&&n>=2){
            int temp=newArray[n-1];
            newArray[n-1]=newArray[n-2];
            newArray[n-2]=temp;
        }
        int count=0;
        for(int i=1;i<n-1;i++)
            if(newArray[i]<newArray[i+1]&&newArray[i]<newArray[i-1])
                count++;
        if(count1>count){
            if(n%2==0&&n>=2){
                int temp=newArray[n-1];
                newArray[n-1]=newArray[n-2];
                newArray[n-2]=temp;
            }
            count=count1;
        }
        System.out.println(count);
        for(int i:newArray)
            System.out.print(i+" ");
        System.out.println();
    } 
}
