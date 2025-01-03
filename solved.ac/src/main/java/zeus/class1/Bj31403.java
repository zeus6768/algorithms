package zeus.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Bj31403 {

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var A = reader.readLine();
        var B = reader.readLine();
        var C = reader.readLine();
        System.out.println(asInteger(A, B, C));
        System.out.println(asString(A, B, C));
    }

    static int asInteger(String A, String B, String C) {
        return Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
    }

    static int asString(String A, String B, String C) {
        return Integer.parseInt(A.concat(B)) - Integer.parseInt(C);
    }
}
