//Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
//
// 
//
// 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。 
//
// 
// 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母 'k' 。 
// 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。 
// 
//
// 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。 
//
// 
// 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。 
// 
//
// 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。 
//
// 由于答案可能很大，将它对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：pressedKeys = "22233"
//输出：8
//解释：
//Alice 可能发出的文字信息包括：
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
//由于总共有 8 种可能的信息，所以我们返回 8 。
// 
//
// 示例 2： 
//
// 输入：pressedKeys = "222222222222222222222222222222222222"
//输出：82876089
//解释：
//总共有 2082876103 种 Alice 可能发出的文字信息。
//由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pressedKeys.length <= 105 
// pressedKeys 只包含数字 '2' 到 '9' 。 
// 
// Related Topics 哈希表 数学 字符串 动态规划 
// 👍 22 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class CountNumberOfTexts {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfTexts().new Solution();
        System.out.println(solution.countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555" +
                "554444444444444444444444444444444555"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> sum3 = new HashMap<>();
        Map<Integer, Integer> sum4 = new HashMap<>();
        int base = 1_000_000_007;

        public int countTexts(String pressedKeys) {

            // key = char+_+index
            // 7和9可以取4
            Map<String, Integer> length = new HashMap<>(pressedKeys.length() / 8);
            int start = 0;
            long ans = 1;
            for (int i = 1; i < pressedKeys.length(); i++) {
                if (pressedKeys.charAt(i) != pressedKeys.charAt(i - 1)) {
                    length.put(pressedKeys.charAt(i - 1) + "_" + start, i - start);
                    if (pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9') {
                        ans *= count4(i - start);
                    } else {
                        ans *= count3(i - start);
                    }
                    ans %= base;
                    start = i;
                }
            }
            if (pressedKeys.charAt(pressedKeys.length() - 1) == '7' || pressedKeys.charAt(pressedKeys.length() - 1) == '9') {
                ans *= count4(pressedKeys.length() - start);
            } else {
                ans *= count3(pressedKeys.length() - start);
            }
            ans %= base;
            return (int) ans;
        }

        // 三步上楼梯
        private int count3(int length) {
            if (length == 1) {
                return 1;
            }
            if (length == 2) {
                return 2;
            }
            if (length == 3) {
                return 4;
            }
            Integer integer = sum3.get(length);
            if (integer != null) {
                return integer;
            }
            int count = (count3(length - 2) + count3(length - 1)) % base + count3(length - 3);
            count %= base;
            sum3.put(length, count);
            return count;
        }

        // 三步,死不兔子上楼梯
        private int count4(int length) {
            if (length == 1) {
                return 1;
            }
            if (length == 2) {
                return 2;
            }
            if (length == 3) {
                return 4;
            }
            if (length == 4) {
                return 8;
            }
            Integer integer = sum4.get(length);
            if (integer != null) {
                return integer;
            }
            int count = (count4(length - 2) + count4(length - 1)) % base + (count4(length - 3) + count4(length - 4)) % base;
            count %= base;
            sum4.put(length, count);
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

