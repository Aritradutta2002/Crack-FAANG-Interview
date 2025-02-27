import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class ColoredRectangles {
    static long[][][]memory;
    static long getMax(int[]red,int[]green,int[]blue,int r,int g,int b){
        r=Math.max(0, r);
        g=Math.max(0, g);
        b=Math.max(0, b);
        if(memory[r][g][b]!=-1)
            return memory[r][g][b];
        if(Math.min(r, g)==0&&Math.min(g,b)==0)
            return 0;
        if(r==0)
            return blue[b-1]*green[g-1]+getMax(red, green, blue, r, g-1, b-1);
        if(b==0)
            return red[r-1]*green[g-1]+getMax(red, green, blue, r-1, g-1, b);
        if(g==0)
            return blue[b-1]*red[r-1]+getMax(red, green, blue, r-1, g, b-1);
        ArrayList<Long>list=new ArrayList<>();
        list.add(getMax(red,green,blue,r-1,g,b));
        list.add(getMax(red,green,blue,r,g-1,b));
        list.add(getMax(red,green,blue,r,g,b-1));
        if(g>0&&r>0)
            list.add(getMax(red, green, blue, r-1, g-1, b)+red[r-1]*green[g-1]);
        if(g>0&&b>0)
            list.add(getMax(red, green, blue, r, g-1, b-1)+green[g-1]*blue[b-1]);
        if(r>0&&b>0)
            list.add(getMax(red, green, blue, r-1, g, b-1)+red[r-1]*blue[b-1]);
        long max=Long.MIN_VALUE;
        for(long l:list)
            max=Long.max(l, max);
        return memory[r][g][b]=max;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader rr=new BufferedReader(new InputStreamReader(System.in));
        String []d1=rr.readLine().split(" ");
        int r=Integer.parseInt(d1[0]);
        int g=Integer.parseInt(d1[1]);
        int b=Integer.parseInt(d1[2]);
        String []a1=rr.readLine().split(" ");
        String []a2=rr.readLine().split(" ");
        String []a3=rr.readLine().split(" ");
        memory=new long[r+1][g+1][b+1];
        for(long[][]a:memory)
            for(long[]z:a)
                Arrays.fill(z, -1);
        int[]red=new int[r];
        int[]green=new int[g];
        int[]blue=new int[b];
        for(int i=0;i<r;i++)
            red[i]=Integer.parseInt(a1[i]);
        for(int i=0;i<g;i++)
            green[i]=Integer.parseInt(a2[i]);
        for(int i=0;i<b;i++)
            blue[i]=Integer.parseInt(a3[i]);
        System.out.println(getMax(red, green, blue, r, g, b));
    } 
    
}