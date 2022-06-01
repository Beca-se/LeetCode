//给你一个聊天记录，共包含 n 条信息。给你两个字符串数组 messages 和 senders ，其中 messages[i] 是 senders[i] 发
//出的一条 信息 。 
//
// 一条 信息 是若干用单个空格连接的 单词 ，信息开头和结尾不会有多余空格。发件人的 单词计数 是这个发件人总共发出的 单词数 。注意，一个发件人可能会发出
//多于一条信息。 
//
// 请你返回发出单词数 最多 的发件人名字。如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。 
//
// 注意： 
//
// 
// 字典序里，大写字母小于小写字母。 
// "Alice" 和 "alice" 是不同的名字。 
// 
//
// 
//
// 示例 1： 
//
// 输入：messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice d
//ay userThree"], senders = ["Alice","userTwo","userThree","Alice"]
//输出："Alice"
//解释：Alice 总共发出了 2 + 3 = 5 个单词。
//userTwo 发出了 2 个单词。
//userThree 发出了 3 个单词。
//由于 Alice 发出单词数最多，所以我们返回 "Alice" 。
// 
//
// 示例 2： 
//
// 输入：messages = ["How is leetcode for everyone","Leetcode is useful for practic
//e"], senders = ["Bob","Charlie"]
//输出："Charlie"
//解释：Bob 总共发出了 5 个单词。
//Charlie 总共发出了 5 个单词。
//由于最多单词数打平，返回字典序最大的名字，也就是 Charlie 。 
//
// 
//
// 提示： 
//
// 
// n == messages.length == senders.length 
// 1 <= n <= 104 
// 1 <= messages[i].length <= 100 
// 1 <= senders[i].length <= 10 
// messages[i] 包含大写字母、小写字母和 ' ' 。 
// messages[i] 中所有单词都由 单个空格 隔开。 
// messages[i] 不包含前导和后缀空格。 
// senders[i] 只包含大写英文字母和小写英文字母。 
// 
// 👍 1 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class SenderWithLargestWordCount {
    public static void main(String[] args) {
        Solution solution = new SenderWithLargestWordCount().new Solution();
        String[] messages = new String[]{"How is leetcode for everyone", "Leetcode is useful for practice" };
        String[] senders = new String[]{"Bob", "Charlie" };
        String s = solution.largestWordCount(messages, senders);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestWordCount(String[] messages, String[] senders) {
            // 先统计每个人发送的单词个数
            AtomicInteger max = new AtomicInteger(-1);
            Map<String, Integer> count = new HashMap<>();
            for (int i = 0; i < senders.length; i++) {
                String sneder = senders[i];
                int wordCount = countWord(messages[i]);
                count.compute(sneder, (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    v += wordCount;
                    max.set(Math.max(v, max.intValue()));
                    return v;
                });
            }
            List<String> senderList = new ArrayList<>();

            count.forEach((k, v) -> {
                if (v == max.intValue()) {
                    senderList.add(k);
                }
            });
            Collections.sort(senderList);
            return senderList.get(senderList.size() - 1);
        }

        private int countWord(String message) {
            int ans = 1;
            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) == ' ') {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

