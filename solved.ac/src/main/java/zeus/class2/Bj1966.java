package zeus.class2;

import java.io.*;
import java.util.*;

public class Bj1966 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    int t;
    int n, m;

    int[] queue;
    Queue<Integer> priorities;

    public static void main(String[] args) throws IOException {
        new Bj1966().run();
    }

    void run() throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) solve();
        br.close();
        bw.close();
    }

    void solve() throws IOException {

        input();

        int index = 0;
        int count = 0;
        while (!priorities.isEmpty()) {
            if (priorities.peek() == queue[index]){
                count++;
                priorities.poll();
                if (index == m) {
                    print(count);
                    break;
                }
            }
            index = (index+1) % n;
        }
    }

    void input() throws IOException {

        priorities = new PriorityQueue<>(Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        queue = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            queue[j] = Integer.parseInt(st.nextToken());
            priorities.add(queue[j]);
        }
    }

    void print(int answer) throws IOException {
        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
    }
}
