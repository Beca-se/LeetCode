//给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
//
// 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大
//的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。 
//
// 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4]
//输出："23:41"
//解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:4
//3"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
// 
//
// 示例 2： 
//
// 
//输入：arr = [5,5,5,5]
//输出：""
//解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,0,0,0]
//输出："00:00"
// 
//
// 示例 4： 
//
// 
//输入：arr = [0,0,1,0]
//输出："10:00"
// 
//
// 
//
// 提示： 
//
// 
// arr.length == 4 
// 0 <= arr[i] <= 9 
// 
// Related Topics 字符串 枚举 
// 👍 80 👎 0

package leetcode.editor.cn;

class LargestTimeForGivenDigits {
    public static void main(String[] args) {
        Solution solution = new LargestTimeForGivenDigits().new Solution();
        solution.largestTimeFromDigits(new int[]{1, 2, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestTimeFromDigits(int[] arr) {
            int ans = -1;
            int len = arr.length, minute, hour;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i == j) {
                        continue;
                    }
                    for (int k = 0; k < len; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        minute = arr[k] * 10 + arr[6 - i - j - k];
                        hour = arr[i] * 10 + arr[j];
                        if (hour < 24 && minute < 60) {
                            ans = Math.max(hour * 60 + minute, ans);
                        }
                    }
                }
            }
            if (ans == -1) {
                return "";
            }
            hour = ans / 60;
            minute = ans % 60;
            String res = "";
            if (hour < 10) {
                res = "0" + hour + ":";
            } else {
                res = hour + ":";
            }
            if (minute < 10) {
                res = res + "0" + minute;
            } else {
                res += minute;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

