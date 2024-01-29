package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14500 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    static final int[][][] TETROMINOS = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {0, -1}, {1, -2}, {1, -1}},

            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {0, -1}, {0, -2}, {1, -2}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
            {{0, 0}, {-1, 0}, {-2, 0}, {-2, -1}},

            {{0, 0}, {0, -1}, {0, 1}, {1, 0}},
            {{0, 0}, {-1, 0}, {0, -1}, {1, 0}},
            {{0, 0}, {-1, 0}, {0, -1}, {0, 1}},
            {{0, 0}, {-1, 0}, {0, 1}, {1, 0}},

            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {0, -1}, {0, -2}, {-1, -2}},
            {{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},

            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
            {{0, 0}, {0, -1}, {-1, -1}, {-1, -2}}
    };

    int n;
    int m;
    int[][] paper;

    int answer;

    public static void main(String[] args) {
        Bj14500 tetromino = new Bj14500();
        tetromino.init();
        tetromino.solve();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(input());
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(tokenizer.nextToken());
                paper[i][j] = number;
            }
        }
        answer = 0;
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] cell = new int[]{i, j};
                putTetrominos(cell);
            }
        }
        System.out.println(answer);
    }

    void putTetrominos(int[] cell) {
        for (int[][] tetromino : TETROMINOS) {
            if (canPut(cell, tetromino)) {
                int score = getScore(cell, tetromino);
                answer = Math.max(answer, score);
            }
        }
    }

    boolean canPut(int[] cell, int[][] tetromino) {
        for (int[] xy : tetromino) {
            int nx = cell[0] + xy[0];
            int ny = cell[1] + xy[1];
            int[] tetrominoCell = new int[]{nx, ny};
            if (!isInRange(tetrominoCell)) {
                return false;
            }
        }
        return true;
    }

    boolean isInRange(int[] cell) {
        return 0 <= cell[0] && cell[0] < n && 0 <= cell[1] && cell[1] < m;
    }

    int getScore(int[] cell, int[][] tetromino) {
        int score = 0;
        for (int[] xy : tetromino) {
            int nx = cell[0] + xy[0];
            int ny = cell[1] + xy[1];
            score += paper[nx][ny];
        }
        return score;
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
