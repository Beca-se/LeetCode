//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 105 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 379 👎 0

package leetcode.editor.cn;

import java.util.*;

class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        int[][] arr = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> lists = solution.pacificAtlantic(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {

            List<List<Integer>> ans = new ArrayList<>();
            int m = heights.length, n = heights[0].length;
            // 第一次遍历能流向大西洋的 逆向思维 水往高处流
            Set<List<Integer>> temp1 = new HashSet<>();
            Set<List<Integer>> temp2 = new HashSet<>();
            for (int i = 0; i < m; i++) {
                temp1.addAll(dfs(heights, i, 0));
                temp2.addAll(dfs(heights, i, n - 1));
            }
            for (int i = 0; i < n; i++) {
                temp1.addAll(dfs(heights, 0, i));
                temp2.addAll(dfs(heights, m - 1, i));
            }
            for (List<Integer> integers : temp1) {
                if (temp2.contains(integers)) {
                    ans.add(integers);
                }
            }
            // 遍历第一次的结果 看是否能流向太平洋
            return ans;
        }

        private Set<List<Integer>> dfs(int[][] heights, int x, int y) {
            // 只要能流到这个坐标的 都加入
            Set<List<Integer>> ans = new HashSet<>();
            Queue<List<Integer>> dequeue = new ArrayDeque<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(x);
            temp.add(y);
            dequeue.add(temp);
            ans.add(temp);
            while (!dequeue.isEmpty()) {
                List<Integer> poll = dequeue.poll();
                // 这里有死循环 相等的时候 互相流 需要一个标记
                // 0
                x = poll.get(0);
                y = poll.get(1);
                if (checkDown(heights, x, y)) {
                    temp = new ArrayList<>();
                    temp.add(x + 1);
                    temp.add(y);
                    if (ans.add(temp)) {
                        dequeue.add(temp);
                    }

                }
                // 1
                if (checkUp(heights, x, y)) {
                    temp = new ArrayList<>();
                    temp.add(x - 1);
                    temp.add(y);
                    if (ans.add(temp)) {
                        dequeue.add(temp);
                    }
                }
                // 2
                if (checkLeft(heights, x, y)) {
                    temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y - 1);
                    if (ans.add(temp)) {
                        dequeue.add(temp);
                    }
                }
                // 3
                if (checkRight(heights, x, y)) {
                    temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y + 1);
                    if (ans.add(temp)) {
                        dequeue.add(temp);
                    }
                }
            }
            return ans;
        }

        private boolean checkLeft(int[][] heights, int x, int y) {
            int value = heights[x][y];
            y--;
            if (y >= 0) {
                return heights[x][y] >= value;
            }
            return false;
        }

        private boolean checkRight(int[][] heights, int x, int y) {
            int value = heights[x][y];
            y++;
            if (y < heights[0].length) {
                return heights[x][y] >= value;
            }
            return false;
        }

        private boolean checkUp(int[][] heights, int x, int y) {
            int value = heights[x][y];
            x--;
            if (x >= 0) {
                return heights[x][y] >= value;
            }
            return false;
        }

        private boolean checkDown(int[][] heights, int x, int y) {
            int value = heights[x][y];
            x++;
            if (x < heights.length) {
                return heights[x][y] >= value;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

