package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1058 {

    int n;
    String[] relations;

    int[] relationCounts;

    public static void main(String[] args) {
        new Bj1058().run();
    }

    void run() {
        input();
        solve();
        print();
    }

    void input() {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(reader.readLine());
            relations = new String[n];
            for (int i = 0; i < n; i++) {
                relations[i] = reader.readLine();
            }
            relationCounts = new int[n];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            String relation = relations[i];
            boolean[] friends = new boolean[n];
            for (int j = 0; j < n; j++) {
                boolean isFriend = relation.charAt(j) == 'Y';
                if (isFriend) {
                    friends[j] = true;
                    String relationOfFriend = relations[j];
                    for (int k = 0; k < n; k++) {
                        boolean isFriendOfFriend = relationOfFriend.charAt(k) == 'Y';
                        friends[k] = isFriendOfFriend && i != k;
                    }
                }
            }
            for (boolean friend : friends) {
                relationCounts[i] += friend ? 1 : 0;
            }
        }
    }

    void print() {
        Arrays.stream(relationCounts).max().ifPresent(System.out::println);
    }
}
