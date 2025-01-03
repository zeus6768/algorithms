package zeus.class1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Bj3052 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A;
    int B = 42;

    Set<Integer> remainder = new HashSet<>();

    public static void main(String[] args) throws IOException {
        new Bj3052().solve();
    }

    void solve() throws IOException {
        for (int i = 0; i < 10; i++) {
            A = Integer.parseInt(br.readLine());
            remainder.add(A % B);
        }
        System.out.println(remainder.size());
    }
}
