import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class TeamName {
    private static HashSet<Character> symmetricDifference(HashSet<Character> a, HashSet<Character> b) {
        HashSet<Character> result = new HashSet<Character>(a);
        for (Character element : b) {
            if(result.contains(element))
                result.remove(element);
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            String[]array = new String[n];
            for(int i = 0; i < n; i++)
                array[i] = t.nextToken();
            HashMap<String, HashSet<Character>>map = new HashMap<>();
            for(String s : array){
                char c = s.charAt(0);
                String left = s.substring(1);
                if(map.containsKey(left))
                    map.get(left).add(c);
                else{
                    map.put(left, new HashSet<>());
                    map.get(left).add(c);
                }
            }

            long c = 0;
            for(String key : map.keySet()){
                boolean b = true;
                for(String key1 : map.keySet()){
                    if(b && !key.equals(key1))
                        continue;
                    if(key.equals(key1)){
                        b = false;
                        continue;
                    }
                    long n1 = symmetricDifference(map.get(key), map.get(key1)).size();
                    long n2 = symmetricDifference(map.get(key1), map.get(key)).size();
                    // System.out.println(key+" "+key1+" "+n1 +" "+n2);
                    c += n1 * n2 * 2;
                }
            }

            System.out.println(c);
        }
    }
        
}
