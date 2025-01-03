package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index = k - 1;
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder answer = new StringBuilder("<");
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        while (!arr.isEmpty()) {
            answer.append(arr.remove(index)).append((arr.isEmpty()) ? ">" : ", ");
            index += k - 1;
            if (index >= arr.size() && !arr.isEmpty()) {
                index = index % arr.size();
            }
        }

        System.out.println(answer);
    }
}
