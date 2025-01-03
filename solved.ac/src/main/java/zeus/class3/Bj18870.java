package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Bj18870 {

    int n;
    List<Integer> coordinates;

    public static void main(String[] args) {
        new Bj18870().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            coordinates = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int coordinate = Integer.parseInt(st.nextToken());
                coordinates.add(coordinate);
            }
        } catch (IOException ignored) {}
    }
    
    void solve() {
        TreeSet<Integer> orderedCoordinates = new TreeSet<>(coordinates);

        Map<Integer, Integer> indices = new HashMap<>();

        int index = 0;
        while (!orderedCoordinates.isEmpty()) {
            Integer coordinate = orderedCoordinates.pollFirst();
            indices.putIfAbsent(coordinate, index);
            index++;
        }

        StringBuilder answer = new StringBuilder();
        for (int coordinate : coordinates) {
            int idx = indices.get(coordinate);
            answer.append(idx).append(' ');
        }

        System.out.print(answer);
    }
}
