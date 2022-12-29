//A 和 B 在一个 3 x 3 的网格上玩井字棋。 
//
// 井字棋游戏的规则如下： 
//
// 
// 玩家轮流将棋子放在空方格 (" ") 上。 
// 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。 
// "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。 
// 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。 
// 如果所有方块都放满棋子（不为空），游戏也会结束。 
// 游戏结束后，棋子无法再进行任何移动。 
// 
//
// 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各
//自的棋子位置。 
//
// 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 
//"Pending"。 
//
// 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。 
//
// 
//
// 示例 1： 
//
// 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
//输出："A"
//解释："A" 获胜，他总是先走。
//"X  "    "X  "    "X  "    "X  "    "X  "
//"   " -> "   " -> " X " -> " X " -> " X "
//"   "    "O  "    "O  "    "OO "    "OOX"
// 
//
// 示例 2： 
//
// 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
//输出："B"
//解释："B" 获胜。
//"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
//"   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
//"   "    "   "    "   "    "   "    "   "    "O  "
// 
//
// 示例 3： 
//
// 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
//输出："Draw"
//输出：由于没有办法再行动，游戏以平局结束。
//"XXO"
//"OOX"
//"XOX"
// 
//
// 示例 4： 
//
// 输入：moves = [[0,0],[1,1]]
//输出："Pending"
//解释：游戏还没有结束。
//"X  "
//" O "
//"   "
// 
//
// 
//
// 提示： 
//
// 
// 1 <= moves.length <= 9 
// moves[i].length == 2 
// 0 <= moves[i][j] <= 2 
// moves 里没有重复的元素。 
// moves 遵循井字棋的规则。 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 66 👎 0

// 找出井字棋的获胜者	题目标题	示例:两数之和
// 1275	题目编号
package leetcode.editor.cn;

class FindWinnerOnATicTacToeGame {
    public static void main(String[] args) {
        Solution solution = new FindWinnerOnATicTacToeGame().new Solution();
        int[][] arr1 = new int[5][2];
        arr1[0] = new int[]{0, 0};
        arr1[1] = new int[]{2, 0};
        arr1[2] = new int[]{1, 1};
        arr1[3] = new int[]{2, 1};
        arr1[4] = new int[]{2, 2};

        solution.tictactoe(arr1);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String tictactoe(int[][] moves) {

            int len = moves.length;
            // move 长度等于0

            int[][] arr = new int[3][3];
            for (int i = 0; i < moves.length; i++) {
                arr[moves[i][0]][moves[i][1]] = (i & 1) == 1 ? -1 : 1;
            }
            int count = 0;
            for (int i = 0; i < 3; i++) {
                count = 0;
                count = arr[0][i] + arr[1][i] + arr[2][i];
                if (count == 3) {
                    return "A";
                }
                if (count == -3) {
                    return "B";
                }
                count = 0;
                count = arr[i][0] + arr[i][1] + arr[i][2];
                if (count == 3) {
                    return "A";
                }
                if (count == -3) {
                    return "B";
                }

            }
            count = 0;
            count = arr[0][0] + arr[1][1] + arr[2][2];
            if (count == 3) {
                return "A";
            }
            if (count == -3) {
                return "B";
            }
            count = 0;
            count = arr[0][2] + arr[1][1] + arr[2][0];
            if (count == 3) {
                return "A";
            }
            if (count == -3) {
                return "B";
            }

            // 没有分出胜负 判断棋局是否结束
            return len == 9 ? "Draw" : "Pending";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}