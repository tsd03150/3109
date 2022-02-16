import java.util.Scanner;

class Main {
    static int n;
    static int m;
    static char[][] board;

    public boolean DFS(int a, int b) {
        board[a][b] = 'x';

        if (b == m - 1) { // 도착했을 때
            return true;
        }

        if (a > 0 && board[a - 1][b + 1] == '.') { // 오른쪽 대각선 위로 이동
            if (DFS(a - 1, b + 1)) {
                return true;
            }
        }

        if (board[a][b + 1] == '.') { // 오른쪽으로 이동
            if (DFS(a, b + 1)) {
                return true;
            }
        }

        if (a < n - 1 && board[a + 1][b + 1] == '.') { // 오른쪽 대각선 아래로 이동
            if (DFS(a + 1, b + 1)) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = kb.next().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (T.DFS(i, 0)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
