package ac.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bj9498 {

    public static void main(String[] args) throws IOException {
        System.out.println(grade(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    static char grade(int score) {
        if (score < 60) return 'F';
        else if (score < 70) return 'D';
        else if (score < 80) return 'C';
        else if (score < 90) return 'B';
        else return 'A';
    }
}
