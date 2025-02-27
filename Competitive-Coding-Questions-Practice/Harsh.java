import java.util.*;
import java.util.stream.IntStream;

public class Harsh {
    
    public static int framesNum; 
    public static int refString[];
    public static int ne;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        
        do{
            System.out.println("Enter Number of Frames: ");
            framesNum = s.nextInt();
        }
        while( framesNum <= 0 );
        
        do{
            System.out.println("Enter the length of Reference String: ");
            ne = s.nextInt();
        }
        while( ne <= 0 );
        
        refString = new int[ne];
        refString = new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};                 for (int i = 0; i < refString.length; i++) {
          refString[i] = rand.nextInt(100);   
        }
     
        enhancedSecondChance();
        
    }
    
        
    private static void enhancedSecondChance(){
        
        int faults = 0;
        int p = 0;
        int inFrames[][] = new int[framesNum][3]; 
        int memory [][] = new int[refString.length][framesNum];
        int refBit[][] = new int[refString.length][framesNum];
        int modifyBit[][] = new int[refString.length][framesNum];
        int intialModifyBit[][] = new int[refString.length][2];
        Random rand = new Random();
        
        for(int j = 0; j < framesNum; j++){
            inFrames[j][0] = -1;   
            inFrames[j][1] = 0;    
            inFrames[j][1] = 0;    
        }
        
        for(int i = 0; i < intialModifyBit.length; i++) {
            
            intialModifyBit[i][1] = rand.nextInt(2);
        }
        
        for(int i = 0; i < refString.length; i++){
            
            boolean check = false;
            ArrayList<Integer> passedByFrames = new ArrayList<>();
            
            for(int j = 0; j < framesNum; j++){

               if(inFrames[j][0] == refString[i]){
                  check = true;
        
                  break;
                } 
            }
            
            if(check == false){
                
                faults++;
                
                int replacementPointer = enhancedSecondChance_00(inFrames, p, i, intialModifyBit, passedByFrames);
                
                if( replacementPointer == -1 ) {
                
                    replacementPointer = enhancedSecondChance_01(inFrames, p, i, intialModifyBit, passedByFrames);
                
        
                    for (int j = 0; j < passedByFrames.size(); j++) {
                        inFrames[(int)passedByFrames.get(j)][1] = 0;
                    }
                    
                    if( replacementPointer == -1 ) {
                        
                        replacementPointer = enhancedSecondChance_00(inFrames, p, i, intialModifyBit, passedByFrames);

                        if( replacementPointer == -1 ) {

                            replacementPointer = enhancedSecondChance_01(inFrames, p, i, intialModifyBit, passedByFrames);
                        }
                        else{
                            p = replacementPointer;
                        }
                    }
                    else{
                        p = replacementPointer;
                    }
                }
                else{
                    p = replacementPointer;
                }
                
            }
            
            for(int j = 0; j < framesNum; j++){
                memory[i][j] = inFrames[j][0];
                refBit[i][j] = inFrames[j][1];
                modifyBit[i][j] = inFrames[j][2];
            }
       }
        printThreeColumns(memory, refBit, modifyBit, faults, "Enhanced Second Chance Algorithm: ");
    }
    
    private static int enhancedSecondChance_00(int inFrames[][], int p, int i, int intialModifyBit[][], ArrayList passedByFrames){
        
        for (int j = p; j < inFrames.length+p; j++) {

            if( inFrames[p][1] == 0 && inFrames[p][2] == 0 ) {

                inFrames[p][0] = refString[i];
                inFrames[p][1] = 1;
                inFrames[p][2] = intialModifyBit[i][1];
        
                p++;

                if(p == framesNum)
                    p = 0;

                
                return p;
            }
            else{
                        
                p++;

                if(p == framesNum)
                    p = 0;
            }
        }
        return -1;
    }
    
    private static int enhancedSecondChance_01(int inFrames[][], int p, int i, int intialModifyBit[][], ArrayList passedByFrames){
        
        for (int j = p; j < inFrames.length+p; j++) {

            if( inFrames[p][1] == 0 && inFrames[p][2] == 1 ) {

                inFrames[p][0] = refString[i];
                inFrames[p][1] = 1;
                inFrames[p][2] = intialModifyBit[i][1];
                  
                if(passedByFrames.contains(p)){
                    passedByFrames.remove((Object)p);
                }

                p++;

                if(p == framesNum)
                    p = 0;


                return p;
            }
            else{
                // inFrames[p][1] = 0;
                
                if(!passedByFrames.contains(p)){
                    passedByFrames.add(p);
                }
                
                p++;

                if(p == framesNum)
                    p = 0;
            }
        }
        return -1;
    }
    
    private static void printThreeColumns(int[][] memory,int[][] refBit,int[][] modifyBit, int faults,String s){
       
       System.out.println("");
        for(int i=0; i<25; i++){
              System.out.print("--");
        }
        System.out.println("");
        System.out.println("Reference String:");    
        for (int i = 0; i < refString.length; i++) {
            System.out.printf("%6d   ",refString[i]);
        }
        System.out.println("\n"); 
       
        System.out.println(s);
        for(int i = 0; i < framesNum; i++){
            for(int j = 0; j < refString.length; j++)
                System.out.printf("%4d %d %d ",memory[j][i],refBit[j][i],modifyBit[j][i]);
            System.out.println("");
        }
        
        System.out.println("The number of Faults: " + faults);
    }
}