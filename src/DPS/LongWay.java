package DPS;

import java.util.*;

/**
 * @Author: jesse
 * @Date: 2020/5/10
 * @Time: 9:42 PM
 */
public class LongWay {


    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //上右下左
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs1(matrix, i, j, memo));
        return ans;
    }

    private int dfs1(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        ++memo[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                memo[i][j] = Math.max(memo[i][j], dfs1(matrix, x, y, memo) + 1);
        }
        return memo[i][j];
    }
//--------------------------------------------


    public int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();
        if (land.length == 0) return new int[0];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    int i1 = dfs2(land, i, j);
                    res.add(i1);
                }
            }
        }
        res.sort(Integer::compareTo);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int dfs2(int[][] land, int i, int j) {

        int area = 0;
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }

        land[i][j] = 3;
        area = area + 1;
        area = area + dfs2(land, i + 1, j);
        area = area + dfs2(land, i - 1, j);
        area = area + dfs2(land, i, j + 1);
        area = area + dfs2(land, i, j - 1);
        area = area + dfs2(land, i + 1, j + 1);
        area = area + dfs2(land, i + 1, j - 1);
        area = area + dfs2(land, i - 1, j + 1);
        area = area + dfs2(land, i - 1, j - 1);
        return area;
    }

    public static void main(String[] args) {
        int[][] r = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        LongWay longWay = new LongWay();
        System.out.println();

    }


}