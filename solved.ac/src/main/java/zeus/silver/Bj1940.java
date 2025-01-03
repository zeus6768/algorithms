package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1940 {

    int n;
    int m;
    List<Integer> materials;

    int answer = 0;

    public static void main(String[] args) {
        new Bj1940().run();
    }

    void run() {
        input();
        solveTwoPointer();
        print();
    }

    void input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            materials = new ArrayList<>();
            var splitter = new StringTokenizer(reader.readLine());
            while (splitter.hasMoreTokens()) {
                var material = Integer.parseInt(splitter.nextToken());
                materials.add(material);
            }
        } catch (IOException ignored) {}
    }

    void solveBruteforce() {
        for (int i = 0; i < n - 1; i++) {
            var material1 = materials.get(i);
            for (int j = i + 1; j < n; j++) {
                var material2 = materials.get(j);
                var sum = material1 + material2;
                if (sum == m) {
                    answer++;
                }
            }
        }
    }

    void solveTwoPointer() {
        Collections.sort(materials);
        int left = 0;
        int right = 1;
        while (left < right && right < n) {
            var material1 = materials.get(left);
            var material2 = materials.get(right);
            var sum = material1 + material2;
            if (sum == m) {
                answer++;
            }
            if (sum < m) {
                right++;
            }
            if (sum >= m) {
                left++;
            }
            System.out.printf("left=%d, material1=%d, right=%d, material2=%d, sum=%d%n", left, material1, right, material2, sum);
        }
    }

    void print() {
        System.out.println(answer);
    }
}
