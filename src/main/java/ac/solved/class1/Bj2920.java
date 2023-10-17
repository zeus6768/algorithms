package ac.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bj2920 {

    static final String ASCENDING = "1 2 3 4 5 6 7 8";
    static final String DESCENDING = "8 7 6 5 4 3 2 1";

    static String answer;

    public static void main(String[] args) throws IOException {
        switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
            case ASCENDING:
                answer = "ascending";
                break;
            case DESCENDING:
                answer = "descending";
                break;
            default:
                answer = "mixed";
        }
        System.out.println(answer);
    }
}
