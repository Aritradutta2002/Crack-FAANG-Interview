// /**
//  * PlanetLapituletti
//  */
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class PlanetLapituletti {
//     static int convert(int n){
//         switch(n){
//             case 0 : 
//             return 0;
//             case 1:
//             return 1;
            
//             case 2:
//             return 5;
            
//             case 5:
//             return 2;

//             default:
//             return -1;
//         }
//     }
//     static void getReverse(int hc, int mc, int h, int m ){
//         String s1 = Integer.toString(hc);
//         char h1 = (s1.length() == 2) ? s1.charAt(1) : '0';
//         char h2 = s1.charAt(0);

//         String s2 = Integer.toString(mc);
//         char m1 = (s2.length() == 2) ? s2.charAt(1) : '0';
//         char m2 = s2.charAt(0);

//         hc = convert(Integer.parseInt(Character.toString(m2))) * 10 + convert(Integer.parseInt(Character.toString(m1)));
//         mc = convert(Integer.parseInt(Character.toString(h2))) * 10 + convert(Integer.parseInt(Character.toString(h1)));

//         String hh =  Integer.toString(convert(Integer.parseInt(Character.toString(m2)))) + Integer.toString(convert(Integer.parseInt(Character.toString(m1))));
//         String mm = Integer.toString(convert(Integer.parseInt(Character.toString(h2)))) + Integer.toString(convert(Integer.parseInt(Character.toString(h1))));

//         if(hc < h && mc < m){
//             System.out.println(hh + ":" + mm);
//         }

        
//     }
//     public static void main(String[] args) throws IOException{
//         BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//         int t1 = Integer.parseInt(r.readLine());
//         while(t1 -- > 0){
//             StringTokenizer t = new StringTokenizer(r.readLine());
//             int h = Integer.parseInt(t.nextToken()), m = Integer.parseInt(t.nextToken());
//             String[] s = r.readLine().split(":");
//             int ch = Integer.parseInt(s[1]);
//             int cm = Integer.parseInt(s[0]);
//             for(int i = cm; i < m; i ++)
//                 getReverse(ch, i, h, m);

//             for(int i = ch + 1; i < h; i ++)
//                 for(int j = 0; )

//         }
        
//     }
    
    
// }