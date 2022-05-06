//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 104 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 
// 👍 17 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

class Five69nqc {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int findMinDifference(List<String> timePoints) {
            int len = timePoints.size();
            if (len > 1440) {
                return 0;
            }
            int[] time = new int[len];
            for (int i = 0; i < len; i++) {
                time[i] = convert(timePoints.get(i));
            }
            Arrays.sort(time);

            int ans = time[0] + 1440 - time[len - 1], diff;
            for (int i = 1; i < len; i++) {
                diff = time[i] - time[i - 1];
                if (diff == 0) {
                    return 0;
                } else {
                    ans = Math.min(ans, diff);
                }
            }
            return ans;
        }

        private int convert(String str) {
            return Integer.parseInt(str.substring(0, 2)) * 60 + Integer.parseInt(str.substring(3));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

