package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj10814 {

    static class Member {

        int index;
        int age;
        String name;

        Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        new Bj10814().solve();
    }

    void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        StringTokenizer st;

        String name;
        int age;

        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            members[i] = new Member(i, age, name);
        }

        Arrays.sort(members, (m1, m2) -> {
            if (m1.age == m2.age)
                return Integer.compare(m1.index, m2.index);
            return Integer.compare(m1.age, m2.age);
        });

        for (Member member : members) {
            answer.append(member.age).append(' ').append(member.name).append('\n');
        }

        System.out.println(answer);
    }
}
