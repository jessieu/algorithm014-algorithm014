// two rounds binary search
// 1. find the row
// 2. find the column
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;

        int first = 0, last = matrix.length - 1;
        while (first <= last) {
            row = first + (last - first) / 2;
            if (matrix[row][0] <= target && matrix[row][matrix[row].length - 1] >= target) {
                break;
            } else if (matrix[row][0] > target) {
                last = row - 1;
            } else {
                first = row + 1;
            }
        }

        first = 0;
        last = row >= 0? matrix[row].length - 1 : -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return false;
    }
}