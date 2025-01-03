package zeus.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj2805 {

    int n, m;
    List<Integer> trees;

    int max;

    public static void main(String[] args) {
        new Bj2805().solve();
    }

    void solve() {
        init();
        int answer = binarySearch();
        System.out.println(answer);
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            trees = new ArrayList<>();
            max = 1;
            for (int i = 0; i < n; i++) {
                int tree = Integer.parseInt(st.nextToken());
                if (max < tree) {
                    max = tree;
                }
                trees.add(tree);
            }
        } catch (Exception ignored) {}
    }

    int binarySearch() {
        int height = 0;
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long length = lengthOfCutTree(mid);
            if (length < m) {
                right = mid - 1;
            } else if (length >= m) {
                height = mid;
                left = mid + 1;
            }
        }
        return height;
    }

    long lengthOfCutTree(int height) {
        long result = 0;
        for (int tree : trees) {
            if (tree > height) {
                result += tree - height;
            }
        }
        return result;
    }
}
