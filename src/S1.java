import java.util.ArrayList;
import java.util.List;

class S1 {

    static List<Integer> capture = new ArrayList<Integer>();
    static int count = 0;

    static boolean isSubsetSum(int[] set, int n, int sum, boolean flag) {
        count++;
        System.out.println("Counter :" + count + " N :" + n + " Sum: " + sum + " Flag: " + flag);
        if (flag) {
            capture.add(set[n]);
        }
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        return isSubsetSum(set, n - 1, sum, false)
                || isSubsetSum(set, n - 1, sum - set[n - 1], true);
    }

    public static void main(String[] args) {
        int[] set = {1, 7, 1, 3};
        int sum = 10;
        int n = set.length;
        if (isSubsetSum(set, n, sum, false))
            System.out.println("Found a subset" + " with given sum. \nElements used is : " + capture.toString());
        else
            System.out.println("No subset with" + " given sum");
        System.out.println("Count: " + count);

    }
}