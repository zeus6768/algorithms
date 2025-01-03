package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public final class Bj28702 {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int INPUT_COUNT = 3;
    private static final Set<String> FIZZ_BUZZ = Set.of("FizzBuzz", "Fizz", "Buzz");

    public static void main(String[] args) throws IOException {
        int number = findNumber();
        String result = fizzBuzz(number);
        System.out.println(result);
    }

    private static int findNumber() throws IOException {
        for (int i = 0; i < INPUT_COUNT; i++) {
            var input = reader.readLine();
            if (!FIZZ_BUZZ.contains(input)) {
                return Integer.parseInt(input) + INPUT_COUNT - i;
            }
        }
        throw new RuntimeException();
    }

    private static String fizzBuzz(int number) {
        if (isMultipleOf(number, 3) && isMultipleOf(number, 5)) {
            return "FizzBuzz";
        }
        if (isMultipleOf(number, 3)) {
            return "Fizz";
        }
        if (isMultipleOf(number, 5)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private static boolean isMultipleOf(int number, int multiplier) {
        return number % multiplier == 0;
    }
}
