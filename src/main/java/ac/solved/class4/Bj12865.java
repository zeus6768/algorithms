package ac.solved.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(READER.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] knapsack = new int[k+1];
        int maxValue = 0;
        while (n-- > 0) {
            tokenizer = new StringTokenizer(READER.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());
            for (int j = k; j >= weight; j--) {
                knapsack[j] = Math.max(knapsack[j], knapsack[j-weight] + value);
                maxValue = Math.max(maxValue, knapsack[j]);
            }
        }
        System.out.println(maxValue);
    }
}
