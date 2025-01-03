package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public final class Bj30804 {

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int MAX_FRUIT_COUNT = 2;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine());
        int[] fruits = new int[n];

        var splitter = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int fruit = Integer.parseInt(splitter.nextToken());
            fruits[i] = fruit;
        }

        var fruitCount = new HashMap<Integer, Integer>();
        int distinctCount = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            int rightFruit = fruits[right];
            fruitCount.merge(rightFruit, 1, Integer::sum);
            if (fruitCount.get(rightFruit) == 1) {
                distinctCount++;
            }

            while (distinctCount > MAX_FRUIT_COUNT) {
                int leftFruit = fruits[left++];
                fruitCount.merge(leftFruit, -1, Integer::sum);
                if (fruitCount.get(leftFruit) == 0) {
                    distinctCount--;
                }
            }

            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }

        System.out.println(maxLength);
    }
}
