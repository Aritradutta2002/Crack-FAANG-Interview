

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[][]mat;
    static boolean isValid(int x,int y,int m,int n){
        return(x>=0&&x<m&&y>=0&&y<n);
    }
    static void edit(int x,int y,int m,int n,int colour,int k){
        mat[x][y]=k;
        int []pos={0,1,0,-1,1,0,-1,0};
        for(int i=0;i<pos.length;i=i+2){
            int newx=x+pos[i];
            int newy=y+pos[i+1];
            if(isValid(newx,newy,m,n)){
                if(mat[newx][newy]==colour){
                    edit(newx,newy,m,n,colour,k);
                }
            }
        }
    }
	public static void main (String[] args)throws IOException {
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		int z=Integer.parseInt(r.readLine());
		for(int t=0;t<z;t++){
		    String []dim=(r.readLine()).split(" ");
		    int m=Integer.parseInt(dim[0]);
		    int n=Integer.parseInt(dim[1]);;
		    String[]data=(r.readLine()).split(" ");
		    mat=new int[m][n];
		    int count=0;
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++){
		            mat[i][j]=Integer.parseInt(data[count]);
		            count++;
		        }
		    }
		  
		    String[]p=(r.readLine()).split(" ");
		    int x=Integer.parseInt(p[0]);
		    int y=Integer.parseInt(p[1]);
		    int k=Integer.parseInt(p[2]);
		    edit(x,y,m,n,mat[x][y],k);
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++){
		            System.out.print(mat [i][j]+" ");
		        }
		    }
		    System.out.println();
		}
		
	}
}
