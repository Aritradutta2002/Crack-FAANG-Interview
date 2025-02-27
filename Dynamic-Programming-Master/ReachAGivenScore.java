import java.util.Arrays;
import java.util.Scanner;

class ReachAGivenScore {
    static int[][]memory;
    static int[]nums;
    static int getMin(int n,int i){
        if(i<0||n<0)
            return 0;
        if(n==0)
            return 1;
        if(memory[i][n]!=-1)
            return memory[i][n];
        return memory[i][n]=getMin(n-nums[i],i)+getMin(n,i-1);
        
    }
	public static void main (String[] args) {
		Scanner sc=new  Scanner(System.in);
		int t=sc.nextInt();
		nums=new int[3];
		nums[0]=3;
		nums[1]=5;
		nums[2]=10;
		while(t-->0){
		    int n=sc.nextInt();
		    memory=new int[3][n+1];
		    for(int[]a:memory)
		        Arrays.fill(a,-1);
		    System.out.println(getMin(n,2));
		    
        }
        sc.close();
	}
}