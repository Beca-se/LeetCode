//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 10⁴ 
// 0 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁴ <= val <= 10⁴ 
// 最多调用 add 方法 10⁴ 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
//
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 400 👎 0
package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest solution = new KthLargestElementInAStream().new KthLargest(2, new int[]{0});
        solution.add(-1);
        solution.add(1);
        solution.add(10);
        solution.add(9);
        solution.add(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        // 最多调用 add 方法 10⁴ 次
        // 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
        // 只返回 不移除 所以是简单题
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int k = -1;

        public KthLargest(int k, int[] nums) {
            for (int num : nums) {
                priorityQueue.add(num);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
            this.k = k;
        }

        public int add(int val) {
            // 如果长度不够k个数 那么说明 这个数需要直接加入队列,然后返回第一个数,不移除
            if (priorityQueue.size() < k) {
                priorityQueue.add(val);
                return priorityQueue.peek();
            }
            // 比较新加入的数和第K大的数的大小
            int temp = priorityQueue.peek();
            if (val <= temp) {
                // 如果小于等于第K个大的数,直接返回第K个数
                return temp;
            }
            // 添加进队列,并移除一个数
            priorityQueue.add(val);
            priorityQueue.poll();
            // 返回第k大的数
            return priorityQueue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
}