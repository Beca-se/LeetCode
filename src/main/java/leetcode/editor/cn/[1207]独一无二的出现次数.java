//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。 
//
// 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：false
// 
//
// 示例 3： 
//
// 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
// Related Topics 哈希表 
// 👍 79 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new UniqueNumberOfOccurrences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            // 利用Map进行2次hash. 第一次记录每一个数字出现的次数, 第2次用出现的次数做key
            HashMap<Integer, Integer> one = new HashMap<>();
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i : arr) {
                Integer integer1 = one.get(i);
                if (integer1 == null) {
                    one.put(i, 1);
                } else {
                    one.put(i, 1 + integer1);
                }
            }
            for (Integer value : one.values()) {
                if (hashSet.contains(value)) {
                    return false;
                }
                hashSet.add(value);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  