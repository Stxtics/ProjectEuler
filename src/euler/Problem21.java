package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem21 {
    private static ArrayList<Integer> amicableNumbers = new ArrayList<>();
    private static ArrayList<Integer> divisorsSum = new ArrayList<>();

    public static void main(String[] args) {
        getDivisorsSum();
        getAmicableNumbers();
        Set<Integer> set = new HashSet<>(amicableNumbers);
        amicableNumbers.clear();
        amicableNumbers.addAll(set);
        System.out.println(sumAmicableNumbers());
    }

    private static void getDivisorsSum() {
        int sum;
        divisorsSum.add(0);
        for (int i = 2; i < 10000; i++) {
            sum = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            divisorsSum.add(sum);
        }
    }

    private static void getAmicableNumbers() {
        for (int i = 0; i < divisorsSum.size() - 2; i++) {
            for (int j = 1; j < divisorsSum.size() - 1; j++) {
                if (j == divisorsSum.get(i) && divisorsSum.get(j - 1) == i + 1 && i != j - 1) {
                    amicableNumbers.add(i + 1);
                    amicableNumbers.add(j);
                }
            }
        }
    }

    private static int sumAmicableNumbers() {
        int sum = 0;
        for (Integer amicableNumber : amicableNumbers) {
            sum += amicableNumber;
        }
        return sum;
    }
}
