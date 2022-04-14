//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 fals
//e。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//输出：true
//解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。 
//
// 示例 2： 
//
// 
//输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//输出：false
//解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。 
//
// 示例 3： 
//
// 
//输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//输出：false
//解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅'
// 是空白字符，定义为比任何其他字符都小（更多信息）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// 在 words[i] 和 order 中的所有字符都是英文小写字母。 
// 
//
// 
//
// 注意：本题与主站 953 题相同： https://leetcode-cn.com/problems/verifying-an-alien-diction
//ary/ 
// Related Topics 数组 哈希表 字符串 
// 👍 21 👎 0

package leetcode.editor.cn;

class LwyVBB {
    public static void main(String[] args) {
        Solution solution = new LwyVBB().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] index = new int[26];

        public boolean isAlienSorted(String[] words, String order) {
            // 先做下标位置映射
            for (int i = 0; i < order.length(); i++) {
                index[order.charAt(i) - 'a'] = i;
            }
            // 逐个比较
            for (int i = 1; i < words.length; i++) {
                // 重写比较规则
                if (compare(words[i - 1], words[i]) < 0) {
                    return false;
                }
            }
            // 比较结果,说明按升序排列的
            return true;

        }

        private int compare(String str1, String str2) {
            int len1 = str1.length(), len2 = str2.length(), len = Math.min(len2, len1);
            char one, two;
            for (int i = 0; i < len; i++) {
                one = str1.charAt(i);
                two = str2.charAt(i);
                if (one == two) {
                    continue;
                }
                return index[two - 'a'] - index[one - 'a'];

            }
            return Integer.compare(len2, len1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

