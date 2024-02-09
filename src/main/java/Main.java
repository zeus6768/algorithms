import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import study.MinStack;

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
        Set<List<Integer>> hashSet = new HashSet<>();
        Set<List<Integer>> linkedHashSet = new LinkedHashSet<>();
        test(hashSet);
        test(linkedHashSet);
    }

    static void test(Set<List<Integer>> set) {
        List<Integer> list1 = List.of(1, 2);
        List<Integer> list2 = List.of(1, 2);
        List<Integer> list3 = List.of(1, 3);
        set.add(list1);
        set.add(list2);
        set.add(list3);
        for (List<Integer> numbers : set) {
            System.out.println(numbers);
        }
    }
}


/*
1. 1 2 3 push 후 min
2. 3 2 1 push 후 min
2. 3 2 1 push pop 후 min

 */