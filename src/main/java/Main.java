import study.MinStack;

import java.io.IOException;

public class Main {

    private void solve(){

        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        minStack.pop();
        System.out.println(minStack.min());
    }

    public static void main(String[] args) throws IOException {

    }
}


/*
1. 1 2 3 push 후 min
2. 3 2 1 push 후 min
2. 3 2 1 push pop 후 min

 */