//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 数学 字符串 
// 👍 568 👎 0


package leetcode.editor.cn;

class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        System.out.println(solution.intToRoman(58));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            // 1 <= num <= 3999
            // 处理千位
            int count = num / 1000;
            num %= 1000;
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < count; i++) {
                // 千位最大为3 直接拼接M
                stringBuilder.append('M');
            }
            // 处理百位
            count = num / 100;
            num %= 100;
            if (count < 4) {
                for (int i = 0; i < count; i++) {
                    // 千位最大为3 直接拼接M
                    stringBuilder.append("C");
                }
            }
            if (count == 4) {
                stringBuilder.append("CD");
            }
            if (count >= 5 && count < 9) {
                stringBuilder.append("D");
                for (int i = 0; i < count - 5; i++) {
                    // 千位最大为3 直接拼接M
                    stringBuilder.append("C");
                }

            }
            if (count == 9) {
                stringBuilder.append("CM");
            }
            // 处理十位
            count = num / 10;
            num %= 10;
            if (count < 4) {
                for (int i = 0; i < count; i++) {
                    // 千位最大为3 直接拼接M
                    stringBuilder.append("X");
                }
            }
            if (count == 4) {
                stringBuilder.append("XL");
            }
            if (count >= 5 && count < 9) {
                stringBuilder.append("L");
                for (int i = 0; i < count - 5; i++) {
                    // 千位最大为3 直接拼接M
                    stringBuilder.append("X");
                }

            }
            if (count == 9) {
                stringBuilder.append("XC");
            }
            // 处理个位
            if (num < 4) {
                for (int i = 0; i < num; i++) {
                    // 千位最大为3 直接拼接M
                    stringBuilder.append("I");
                }
            }
            if (num == 4) {
                stringBuilder.append("IV");
            }
            if (num >= 5 && num < 9) {
                stringBuilder.append("V");
                for (int i = 0; i < num - 5; i++) {
                    // 千位最大为3 直接拼接M
                    stringBuilder.append("I");
                }

            }
            if (num == 9) {
                stringBuilder.append("IX");
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  