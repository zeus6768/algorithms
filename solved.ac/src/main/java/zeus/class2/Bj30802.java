package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj30802 {

    int n;
    int[] sizes;
    int t;
    int p;

    int shirtBundleSize, penBundleSize, penEachSize;

    public static void main(String[] args) {
        new Bj30802().run();
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
            sizes = new int[6];
            var sizesInput = new StringTokenizer(reader.readLine());
            var index = 0;
            while (sizesInput.hasMoreTokens()) {
                sizes[index] = Integer.parseInt(sizesInput.nextToken());
                index++;
            }
            var bundles = new StringTokenizer(reader.readLine());
            t = Integer.parseInt(bundles.nextToken());
            p = Integer.parseInt(bundles.nextToken());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    void solve() {
        for (int size : sizes) {
            shirtBundleSize += size / t;
            shirtBundleSize += (size % t != 0) ? 1 : 0;
        }
        penBundleSize = (n / p);
        penEachSize = (n % p);
    }

    void print() {
        var answer = String.format("%s\n%s %s",
                shirtBundleSize,
                penBundleSize,
                penEachSize);
        System.out.println(answer);
    }
}
