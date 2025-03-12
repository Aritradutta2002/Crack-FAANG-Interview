
import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        towerOfHanoi(n, 1, 2, 3);
        System.out.println("Total moves required: " + moves.size());
        for(var ele : moves) {
            System.out.println(ele);
        }
        System.out.println(moves);
    }

    public static List<String> moves = new ArrayList<>();
    public static void towerOfHanoi(int n, int source, int helper, int destination) {
        if (n == 1) {
            moves.add(source + " -> " + destination);
            return;
        }
        /* Move top (n - 1) disks from source to helper using destination */
        towerOfHanoi(n - 1, source, destination, helper);

        /* Move remaining disk from source to destination */
        moves.add(source + " -> " + destination);

        /* Move (n-1) disks from helper to destination using source */
        towerOfHanoi(n - 1, helper, source, destination);
    }
}
