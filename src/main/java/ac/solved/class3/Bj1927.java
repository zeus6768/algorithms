package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bj1927 {


    public static void main(String[] args) throws IOException {

        StringBuilder answer = new StringBuilder();

        Queue<Integer> minHeap = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (minHeap.isEmpty()) {
                    answer.append(0);
                } else {
                    answer.append(minHeap.poll());
                }
                answer.append('\n');
            } else {
                minHeap.offer(input);
            }
        }

        System.out.println(answer);
    }
}
