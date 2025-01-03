package zeus.class2;

import java.io.*;

public class Bj10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[10001];
        for (int i = 0; i < n; i++) {
            nums[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 1; i < 10001; i++) {
            while (nums[i] != 0) {
                answer.append(i).append('\n');
                nums[i]--;
            }
        }

        System.out.println(answer);
    }
}
