// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Deque;
// import java.util.StringTokenizer;

// public class MaximumOfAllSubarraysOfSizek {

//     static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
//     {
//         Deque<Integer>q = new Deque<>();    
//         ArrayList<Integer>list = new ArrayList<>();
//         for(int i = 0 ; i < k; i ++)
//             add(q, arr[i]);
//         list.add(q.peekFirst());

//         for(int i = k; i < n; i ++){
            
//             if(q.peekFirst() == arr[i - k])
//                 q.removeFirst();
//             add(q, arr[i]);
//             list.add(q.peekFirst());
//         }
//         return list;

//     }

//     static void add(Deque<Integer>q, int n){
//         while(!q.isEmpty())
//             if(q.peekLast() < n)
//                 q.removeLast();
//             else
//                 break;
//         q.add(n);
//     }


//     public static void main(String[] args) throws IOException{
//         BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//         int t1 = Integer.parseInt(r.readLine());
//         while(t1 -- > 0 ){
//             StringTokenizer t = new StringTokenizer(r.readLine());
//             int n = Integer.parseInt(t.nextToken());
//             int k = Integer.parseInt(t.nextToken());
//             t = new StringTokenizer(r.readLine());            
//             int[]array = new int[n];
//             for(int i = 0; i < n; i ++)
//                 array[i] = Integer.parseInt(t.nextToken());
//             System.out.println(max_of_subarrays(array, n, k));
//         }
//     }
        
// }
