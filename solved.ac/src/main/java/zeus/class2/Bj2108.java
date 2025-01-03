package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj2108 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();

    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(br.readLine());
        answer.append(average()).append('\n')
                .append(medium()).append('\n')
                .append(mode()).append('\n')
                .append(range()).append('\n');
        System.out.println(answer);
    }

    static int average() {
        double sum = 0;
        for (int x : numbers) sum += x;
        return (int) (Math.round(sum / N));
    }

    static int medium() {
        Arrays.sort(numbers);
        return numbers[N/2];
    }

    static int mode() {
        Integer mode = null;
        int maxCount = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            count.computeIfPresent(numbers[i], (k, v) -> v+1);
            count.putIfAbsent(numbers[i], 1);
            if (maxCount < count.get(numbers[i])) maxCount = count.get(numbers[i]);
        }
        // 최빈값 key를 찾는다.
        for (int i = 0; i < N; i++) {
            if (count.get(numbers[i]) == maxCount) {
                if (mode != null && mode != numbers[i]) {
                    return numbers[i];
                }
                mode = numbers[i];
            }
        }
        return mode;
    }

    static int range() {
        return numbers[N-1] - numbers[0];
    }
}
