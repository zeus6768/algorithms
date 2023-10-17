package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Bj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> cardDeque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) cardDeque.addLast(i);
        boolean remove = true;
        while (cardDeque.size() > 1) {
            if (remove) cardDeque.pollFirst();
            else cardDeque.addLast(cardDeque.pollFirst());
            remove = !remove;
        }
        System.out.println(cardDeque.pollFirst());
    }
}
