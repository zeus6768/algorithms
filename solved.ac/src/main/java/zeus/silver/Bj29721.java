package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj29721 {

    int n;
    int k;
    Set<Position> dabbabas;

    int answer;

    public static void main(String[] args) {
        new Bj29721().run();
    }

    void run() {
        input();
        solve();
        print();
    }

    void input() {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var splitter = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(splitter.nextToken());
            k = Integer.parseInt(splitter.nextToken());
            dabbabas = new HashSet<>();
            for (int i = 0; i < k; i++) {
                splitter = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(splitter.nextToken()) - 1;
                int y = Integer.parseInt(splitter.nextToken()) - 1;
                var position = new Position(x, y);
                dabbabas.add(position);
            }
        } catch (IOException ignored) {}
    }

    void solve() {
        final var directions = List.of(
                new Position(2, 0), new Position(0, 2),
                new Position(-2, 0), new Position(0, -2));
        final var possiblePositions = new HashSet<Position>();
        dabbabas.forEach(dabbaba -> directions.stream()
                .map(dabbaba::add)
                .filter(position -> position.isBound(n))
                .filter(position -> !dabbabas.contains(position))
                .forEach(possiblePositions::add));
        answer = possiblePositions.size();
    }

    void print() {
        System.out.println(answer);
    }

    static class Position {

        final int x;
        final int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isBound(int max) {
            return (0 <= x && x < max) && (0 <= y && y < max);
        }

        Position add(Position other) {
            return new Position(x + other.x, y + other.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Position)) {
                return false;
            }
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
