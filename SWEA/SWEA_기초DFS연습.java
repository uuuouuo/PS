
public class SWEA_기초DFS연습_UserSolution {

    private int[][] node;
    private int[] cnt;
    private int[] stack;

    public void dfs_init(int N, int[][] path) {
        node = new int[100][5];
        cnt = new int[100];

        for (int i = 0; i < N && path[i][0] != 0; i++) {
            int p = path[i][0];
            int c = path[i][1];

            node[p][cnt[p]] = c;
            cnt[p]++;
        }
    }

    public int dfs(int N) {
        int result = -1;
        boolean[] check = new boolean[100];
        stack = new int[40];
        int top = -1;
        stack[++top] = N;

        while (top != -1) {
            int cur = stack[top--];
            if (check[cur])
                continue;
            check[cur] = true;

            if (cur > N) {
                result = cur;
                break;
            }

            int idx = cnt[cur];
            for (int i = idx - 1; i >= 0; i--) {
                int next = node[cur][i];
                if (check[next])
                    continue;
                stack[++top] = next;
            }
        }
        return result;
    }

}
