
import java.util.*;
import java.lang.*;
import java.io.*;

//~~~~~~~~~~~~~~~~~~~~~~~~~Using Backtracking~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class Solution {
	static int backtrack(int[]array,int pos){
	    if(pos==30){
	        return 0;
	    }
	    int dSteps=(30-pos)/6;
	    if((30-pos)%6!=0){
	        dSteps++;
	    }
	    int min=dSteps;
	    for(int i=0;i<array.length;i+=2){
	        int start=array[i];
	        int end=array[i+1];
	        if(start>=pos&&end>start){
	            int steps=(array[i]-pos)/6;
	            if((array[i]-pos)%6!=0){
	                steps++;
	            }
	            steps+=backtrack(array,array[i+1]);
	            if(steps<min){
	                min=steps;
	            }
	        }
	    }
	    
	    return min;
	}
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		while(n-->0){
		    sc.nextLine();
		    String []data=sc.nextLine().split(" ");
		    int[]array=new int[data.length];
		    for(int i=0;i<data.length;i++){
		        array[i]=Integer.parseInt(data[i]);
		      //  System.out.print(array[i]+" ");
		    }
		    System.out.println(backtrack(array,1));
		}
		
	}
}
