package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Bj19637 {

    static class Titles {

        List<Title> titles;
        Set<Integer> powers;

        Titles() {
            titles = new ArrayList<>();
            powers = new HashSet<>();
        }

        void add(Title title) {
            if (powers.contains(title.power)) {
                return;
            }
            titles.add(title);
            powers.add(title.power);
        }

        String getTitleNameByPower(int power) {
            var title = binarySearchByPower(power);
            return title.name;
        }

        Title binarySearchByPower(int power) {
            var left = 0;
            var right = titles.size();
            var mid = (left + right) / 2;
            while (left < right) {
                var title = titles.get(mid);
                if (title.power < power) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
                mid = (left + right) / 2;
            }
            return titles.get(mid);
        }
    }

    static class Title {

        String name;
        int power;

        Title(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }

    public static void main(String[] args) {
        new Bj19637().run();
    }

    int n;
    int m;

    Titles titles;
    List<Integer> powers;

    Object answer;

    void run() {
        input();
        solve();
        output();
    }

    void input() {
        try (final var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var splitter = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(splitter.nextToken());
            m = Integer.parseInt(splitter.nextToken());
            titles = new Titles();
            for (int i = 0; i < n; i++) {
                splitter = new StringTokenizer(reader.readLine());
                var name = splitter.nextToken();
                var power = Integer.parseInt(splitter.nextToken());
                var title = new Title(name, power);
                titles.add(title);
            }
            powers = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                var power = Integer.parseInt(reader.readLine());
                powers.add(power);
            }
        } catch (IOException ignored) {
        }
    }

    void solve() {
        answer = powers.stream()
                .map(power -> titles.getTitleNameByPower(power))
                .collect(Collectors.joining("\n"));
    }

    void output() {
        System.out.println(answer);
    }
}
