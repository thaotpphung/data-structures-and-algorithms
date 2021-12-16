import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://stackoverflow.com/questions/52562585/maximal-value-among-shortest-distances-in-a-matrix

class Result {

  /*
   * Complete the 'findMinDistance' function below.
   *
   * The function is expected to return an INTEGER. The function accepts following
   * parameters: 1. INTEGER w 2. INTEGER h 3. INTEGER n
   */
  static int[] dx = new int[] { 1, -1, 0, 0 };
  static int[] dy = new int[] { 0, 0, -1, 1 };

  public static int findMinDistance(int w, int h, int n) {
    int[][] grid = new int[w][h];
    for (int i = 0; i < w; i++) {
      Arrays.fill(grid[i], -1);
    }
    return solve(n, w, h, 0, 0, grid);
  }
  
  static int solve(int left, int w, int h, int row, int col, int[][] grid) {
    if (left == 0)
      return bfs(w, h, grid);
    int r = row, c = col;
    if (col >= h) {
      r += col / h;
      c = col % h;
    }
    int minDist = Integer.MAX_VALUE;
    for (int i = r; i < w; i++) {
      for (int j = c; j < h; j++) {
        grid[i][j] = 0;
        int val = solve(left - 1, w, h, i, j + 1, grid);
        minDist = Math.min(minDist, val);
        grid[i][j] = -1;
      }
    }
    return minDist;
  }
  
  static int bfs(int w, int h, int grid[][]) {
    int[][] dist = new int[w][h];
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        dist[i][j] = grid[i][j];
      }
    }
    int maxDist = 0;
    Queue<Location> queue = new LinkedList<>();
    for (int x = 0; x < w; x++) {
      for (int y = 0; y < h; y++) {
        if (dist[x][y] == 0) {
          queue.add(new Location(x, y));
        }
      }
    }
    while (!queue.isEmpty()) {
      int x = queue.peek().x;
      int y = queue.peek().y;
      maxDist = Math.max(maxDist, dist[x][y]);
      queue.poll();
      for (int d = 0; d < 4; d++) {
        int newX = x + dx[d];
        int newY = y + dy[d];
        if (newX >= w || newY >= h || newX < 0 || newY < 0)
          continue;
        if (dist[newX][newY] == -1) {
          dist[newX][newY] = dist[x][y] + 1;
          queue.add(new Location(newX, newY));
        }
      }
    }
    return maxDist;
  }
  
  static class Location {
    int x, y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int w = Integer.parseInt(bufferedReader.readLine().trim());

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.findMinDistance(w, h, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
