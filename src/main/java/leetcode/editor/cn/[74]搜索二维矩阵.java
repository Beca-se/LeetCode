//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 357 👎 0


package leetcode.editor.cn;

class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[] arr = new int[]{1};
        int i = solution.binarySearch(arr, 2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int yLength;
            if (matrix == null || (yLength = matrix.length) < 1) {
                return false;
            }
            int xLength = matrix[0].length;
            // 检查边界
            if (matrix[0][0] > target || matrix[yLength - 1][xLength - 1] < target) {
                return false;
            }
            int i = 1;
            for (; i <= yLength; i++) {

                if (i == yLength || matrix[i][0] > target) {
                    i--;
                    break;
                }
            }
            int i1 = binarySearch(matrix[i], target);
            return i1 != -1;
        }


        public int binarySearch(int[] matrix, int target) {
            int right;
            if (matrix == null || (right = matrix.length) < 1) {
                return -1;
            }
            int left = 0;
            int mid;
            right = right - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (matrix[mid] == target) {
                    return mid;
                } else if (matrix[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  