import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    Binary Search
    https://www.codechef.com/problems/STACKS
*/
class Stack {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            r.readLine();
            int count=0;
            String[]s=r.readLine().split(" ");
            long[]array=new long[s.length];
            for(int i=0;i<array.length;i++){
                array[i]=Long.parseLong(s[i]);
            }
            long[]stacks=new long[s.length];
            Arrays.fill(stacks, Long.MAX_VALUE);
            for(long i:array){
                int pos=Arrays.binarySearch(stacks, i);
                if(pos>=0){
                    while(stacks[pos]<=i){
                        pos++;
                    }
                    stacks[pos]=i;

                }
                else{
                    pos=Math.abs(pos)-1;
                    stacks[pos]=i;
                }
            }
            for(long i:stacks){
                if(i==Long.MAX_VALUE){
                    break;
                }
                count++;
            }
            System.out.print(count+" ");
            for(long i:stacks){
                if(i==Long.MAX_VALUE){
                    break;
                }
                System.out.print(i+" ");
            }
            
            System.out.println();

        }
    }
}