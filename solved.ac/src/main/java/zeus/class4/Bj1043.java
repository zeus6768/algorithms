package zeus.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj1043 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer tokenizer;

    int n;
    int m;

    Set<Integer> initialTruthKnowers;
    Set<Integer> truthKnowners;
    List<Set<Integer>> parties;
    List<Set<Integer>> relationship;

    int answer;

    public static void main(String[] args) {
        Bj1043 main = new Bj1043();
        main.init();
        main.solve();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        answer = 0;
        initTruthKnower();
        initParties();
        initRelationship();
    }

    void initTruthKnower() {
        tokenizer = new StringTokenizer(input());
        initialTruthKnowers = new HashSet<>();
        truthKnowners = new HashSet<>();
        int truthKnowerCount = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < truthKnowerCount; i++) {
            int person = Integer.parseInt(tokenizer.nextToken());
            initialTruthKnowers.add(person);
        }
    }

    void initParties() {
        parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> party = new HashSet<>();
            tokenizer = new StringTokenizer(input());
            int partyPeopleCount = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < partyPeopleCount; j++) {
                int person = Integer.parseInt(tokenizer.nextToken());
                party.add(person);
            }
            parties.add(party);
        }
    }

    void initRelationship() {
        relationship = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            relationship.add(new HashSet<>());
        }
        for (Set<Integer> party : parties) {
            for (int person : party) {
                relationship.get(person).addAll(party);
            }
        }
    }

    void solve() {
        addTruthKnowers();
        countParty();
        System.out.println(answer);
    }

    void addTruthKnowers() {
        for (int knowner : initialTruthKnowers) {
            dfs(knowner);
        }
    }

    void dfs(int person) {
        truthKnowners.add(person);
        Set<Integer> friends = relationship.get(person);
        for (int friend : friends) {
            if (!truthKnowners.contains(friend)) {
                dfs(friend);
            }
        }
    }

    void countParty() {
        for (Set<Integer> party : parties) {
            if (!isTruthKnown(party)) {
                answer++;
            }
        }
    }

    boolean isTruthKnown(Set<Integer> party) {
        for (int person : party) {
            if (truthKnowners.contains(person)) {
                return true;
            }
        }
        return false;
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
