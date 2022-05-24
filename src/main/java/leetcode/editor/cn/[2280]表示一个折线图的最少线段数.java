//给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 pri
//cei 。折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子： 
//
// 请你返回要表示一个折线图所需要的 最少线段数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
//输出：3
//解释：
//上图为输入对应的图，横坐标表示日期，纵坐标表示价格。
//以下 3 个线段可以表示折线图：
//- 线段 1 （红色）从 (1,7) 到 (4,4) ，经过 (1,7) ，(2,6) ，(3,5) 和 (4,4) 。
//- 线段 2 （蓝色）从 (4,4) 到 (5,4) 。
//- 线段 3 （绿色）从 (5,4) 到 (8,1) ，经过 (5,4) ，(6,3) ，(7,2) 和 (8,1) 。
//可以证明，无法用少于 3 条线段表示这个折线图。
// 
//
// 示例 2： 
//
// 
//
// 输入：stockPrices = [[3,4],[1,2],[7,8],[2,3]]
//输出：1
//解释：
//如上图所示，折线图可以用一条线段表示。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stockPrices.length <= 105 
// stockPrices[i].length == 2 
// 1 <= dayi, pricei <= 109 
// 所有 dayi 互不相同 。 
// 
// 👍 8 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

class MinimumLinesToRepresentALineChart {
    public static void main(String[] args) {
        Solution solution = new MinimumLinesToRepresentALineChart().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLines(int[][] stockPrices) {
            int length = stockPrices.length;
            // 可能只有一个点,一个点不需要线段
            if (length == 1) {
                return 0;
            }
            // 排序
            Arrays.sort(stockPrices, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            // 计算斜率
            int ans = 1;
            for (int i = 1; i < length; i++) {
                stockPrices[i - 1] = new int[]{stockPrices[i][1] - stockPrices[i - 1][1], stockPrices[i][0] - stockPrices[i - 1][0]};
                if (i > 1) {
                    long temp1 = stockPrices[i - 1][0] * stockPrices[i - 2][1];
                    long temp2 = stockPrices[i - 1][1] * stockPrices[i - 2][0];
                    if (temp1 != temp2) {
                        ans++;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

