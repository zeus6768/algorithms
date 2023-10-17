package ac.solved.class2;

import java.io.*;

class Bj1259 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer;

        String number;
        int length;

        while (!(number = br.readLine()).equals("0")) {
            answer = "yes";
            length = number.length();
            for (int i = 0; i <= length/2; i++) {
                if (number.charAt(i) != number.charAt(length - i - 1)) {
                    answer = "no";
                    break;
                }
            }
            bw.write(answer);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
