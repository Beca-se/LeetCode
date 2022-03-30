//给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来
//判断，这些点是否在该坐标系中属于同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
// Related Topics 几何 数组 数学 
// 👍 109 👎 0

package leetcode.editor.cn;

class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        Solution solution = new CheckIfItIsAStraightLine().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            // 选2个点
            int[] one = coordinates[0];
            int[] two = coordinates[1];
            int x1 = one[0], y1 = one[1], x2 = two[0], y2 = two[1], b = 0;

            // 判断是否是平行Y轴的,平行Y轴的不是一般的函数
            if (x1 == x2) {
                for (int[] coordinate : coordinates) {
                    if (coordinate[0] != x1) {
                        return false;
                    }
                }
                return true;
            }
            // 计算出斜率
            double a = (double) (y2 - y1) / (x2 - x1);
            b = y1 - (int) (x1 * a);
            for (int[] coordinate : coordinates) {
                // 比较结果
                if (coordinate[1] != b + (coordinate[0] * a)) {
                    return false;
                }
            }
            return true;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

