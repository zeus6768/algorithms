package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1541 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Bj1541().solve();
    }

    void solve() throws IOException {
        String formula = br.readLine();
        String[] splitFormula = formula.split("-");
        int answer = valueFromPlusFormula(splitFormula[0]);
        for (int i = 1; i < splitFormula.length; i++) {
            answer -= valueFromPlusFormula(splitFormula[i]);
        }
        System.out.println(answer);
    }

    int valueFromPlusFormula(String formula) {
        int result = 0;
        String[] splitNumbers = formula.split("\\+");
        for (String number : splitNumbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
