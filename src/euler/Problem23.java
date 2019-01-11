package euler;

import java.util.ArrayList;

public class Problem23 {
    private static ArrayList<Integer> abundantIntegers = new ArrayList<>();

    public static void main(String[] args) {
        getAbundantNumbers();
        System.out.println(unSummableNumbersSum());
    }

    private static void getAbundantNumbers() {
        for (int i = 1; i < 28123; i++) {
            int sum = 0;
            for (int j = i / 2; j > 0; j--) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum > i) {
                abundantIntegers.add(i);
            }
        }
    }

    private static int unSummableNumbersSum() {
        int sum = 0;
        boolean summable;
        for (int i = 1; i <= 28123; i++) {
            summable = false;
            for (int j = 0; j < abundantIntegers.size() - 2; j++) {
                if (abundantIntegers.get(j) > i) {
                    break;
                }
                for (int k = 0; k < abundantIntegers.size() - 1; k++) {
                    if (abundantIntegers.get(k) > i) {
                        break;
                    }
                    if (abundantIntegers.get(j) + abundantIntegers.get(k) == i) {
                        summable = true;
                        j += abundantIntegers.size();
                        break;
                    }
                }
            }
            if (!summable) {
                sum += i;
            }
        }
        return sum;
    }
}
