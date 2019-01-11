package euler;

public class Problem24 {
    private static int permutationCount = 0;

    public static void main(String[] args) {
        permutation("", "0123456789");
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            permutationCount++;
            if (permutationCount == 1000000) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}
