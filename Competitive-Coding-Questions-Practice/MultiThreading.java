// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class MultiThreading {
//     int i = 0;
//     void increment(){
//         i += 1;
//     }

    
//     public static void main(String[] args) throws IOException{
        
//         Runnable r = () -> {
//             try {Thread.sleep(1000);} catch (Exception e){}
//             System.out.println("start");

//             for(int i = 0; i < arr.length; i++){
//                 // c += 1;
//                 arr[i] = 3;
//                 System.out.println("iteration no. : " + i);
//                 try {Thread.sleep(1000);} catch (Exception e){}
//             }

//             for (int i : arr)
//                 System.out.print(i + " ");
//             System.out.println();
//         };

//         Thread t = new Thread(r);
//         t.start();

//         try {Thread.sleep(5000);} catch (Exception e){}
        
//         System.out.println(c);
//         for (int i : arr)
//             System.out.print(i + " ");
//         System.out.println();
//     }
        
// }
