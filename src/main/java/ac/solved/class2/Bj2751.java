package ac.solved.class2;

import java.io.*;
import java.util.Arrays;

public class Bj2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        StringBuilder answer = new StringBuilder();

        for (int num : nums) answer.append(num).append('\n');

        System.out.println(answer);
    }
}
