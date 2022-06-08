//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
//
// 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/ 
// Related Topics 数组 哈希表 字符串 排序 
// 👍 31 👎 0

package leetcode.editor.cn;

import java.util.*;

class Sfvd7V {
    public static void main(String[] args) {
        Solution solution = new Sfvd7V().new Solution();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strings));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> count = new HashMap<>();
            for (String str : strs) {
                String key = getKey(str);

                count.compute(key, (k, v) -> {
                    if (v == null) {
                        v = new ArrayList<>();
                    }
                    v.add(str);
                    return v;
                });
            }
            return new ArrayList<>(count.values());
        }

        public String getKey(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

